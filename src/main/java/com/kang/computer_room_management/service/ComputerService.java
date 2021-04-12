package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AppointmentRecordMapper;
import com.kang.computer_room_management.mapper.ComputerMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import com.kang.computer_room_management.mapper.StUserMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComputerService implements IComputerService {
    Utils utils=new Utils();
    final StUserMapper stUserMapper;
    final private ComputerMapper computerMapper;
    final  private ComputerRoomMapper computerRoomMapper;
    final  private IComputerRoomService computerRoomService;
    final private AppointmentRecordMapper appointmentRecordMapper;
    @Autowired
    public ComputerService(StUserMapper stUserMapper, ComputerMapper computerMapper, ComputerRoomMapper computerRoomMapper, IComputerRoomService computerRoomService, AppointmentRecordMapper appointmentRecordMapper) {
        this.stUserMapper = stUserMapper;
        this.computerMapper = computerMapper;
        this.computerRoomMapper = computerRoomMapper;
        this.computerRoomService = computerRoomService;
        this.appointmentRecordMapper = appointmentRecordMapper;
    }

    @Override
    public List<Computer> findComputers(Computer computer) {
        //computerRoomService.updateRoomStatus();
        //查找所有状态等于输入状态的机子集合
        try {
            ComputerExample computerExample = new ComputerExample();
            ComputerRoomExample computerRoomExample=new ComputerRoomExample();
            computerRoomExample.createCriteria().andRstatusEqualTo(-1);
            List<ComputerRoom> computerRooms=computerRoomMapper.selectByExample(computerRoomExample);
            List<Integer> ridInStatusUp=new ArrayList<>();
            for(ComputerRoom computerRoom:computerRooms){
                ridInStatusUp.add(computerRoom.getRid());
            }
            computerExample.createCriteria().andCstatusEqualTo(computer.getCstatus()).andRidIn(ridInStatusUp);
            List<Computer> computers = computerMapper.selectByExample(computerExample);
            return computers.size()>0?computers:null;
        }catch (RuntimeException e){
            utils.printLog(e);
            return null;
        }
    }

    @Override
    public void setComputerStatusUp(int cid) {
        //将指定机子状态设置为可用
        Computer computer=computerMapper.selectByPrimaryKey(cid);
        computer.setCstatus(1);
        computerMapper.updateByPrimaryKeySelective(computer);
    }

    @Override
    public void setComputerStatusDown(int cid) {
        //将指定机子状态设置为不可用
        Computer computer=computerMapper.selectByPrimaryKey(cid);
        computer.setCstatus(0);
        computerMapper.updateByPrimaryKeySelective(computer);
    }

    @Override
    public int freeComputerInRoom(int roomId) {
        ComputerExample computerExample=new ComputerExample();
        computerExample.createCriteria().andCstatusEqualTo(1).andRidEqualTo(roomId);
        return computerMapper.countByExample(computerExample);
    }


    @Override
    public String showComputers(HttpServletRequest httpServletRequest) {
        HttpSession httpSession = httpServletRequest.getSession();
        JSONArray jSonArray=new JSONArray();
        for(int i=1;i<31;i++){
            int id=((int)httpSession.getAttribute("nowRoom")-1)*30+i;
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("status",computerMapper.selectByPrimaryKey(id).getCstatus());
            jSonArray.put(jsonObject);
        }
        if(utils.isUserLogin(httpServletRequest)) {
            StUser stUser = stUserMapper.selectByPrimaryKey((int) httpSession.getAttribute("uid"));
            return "{\"rid\":" + httpSession.getAttribute("nowRoom") + ",\"uname\":\"" + httpSession.getAttribute("uname") + "\"," +
                    "\"uprofile\":\"" + stUser.getUprofile() + "\",\"computerList\":"+jSonArray+"}";
        }else{
            return "{\"rid\":" + httpSession.getAttribute("nowRoom") + ",\"uname\":\"未登录\"," +
                    "\"uprofile\":\"未登录\",\"computerList\":"+jSonArray+"}";
        }
    }

    @Override
    public String showComputersPage(Model model,HttpServletRequest httpServletRequest) {
        if(utils.isUserLogin(httpServletRequest)) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            simpleDateFormat.applyPattern("MM月dd日 HH:mm:ss");
            model.addAttribute("time", simpleDateFormat.format(date));
            return "showComputers";
        }
        else return "login";
    }

    @Override
    public String chooseComputers(int cid,HttpServletRequest httpServletRequest) {
        AppointmentRecord appointmentRecord=new AppointmentRecord();
        appointmentRecord.setUid((int)httpServletRequest.getSession().getAttribute("uid"));
        appointmentRecord.setRid((int)httpServletRequest.getSession().getAttribute("nowRoom"));
        appointmentRecord.setCid(cid+((int)httpServletRequest.getSession().getAttribute("nowRoom")*30-30));
        appointmentRecord.setArtype(1);
        appointmentRecord.setReqdate(new Date());
        appointmentRecord.setArstatus(0);
        appointmentRecordMapper.insert(appointmentRecord);
        setComputerStatusDown(cid+(int)httpServletRequest.getSession().getAttribute("nowRoom")*30-30);
        return "{\"code\":\"1\"}";
    }

    @Override
    public void updateComputerStatus() {
        List<Integer> cidIna=new ArrayList<>();
        AppointmentRecordExample appointmentRecordExample=new AppointmentRecordExample();
        appointmentRecordExample.createCriteria().andArstatusBetween(0,1);
        List<AppointmentRecord> appointmentRecords=appointmentRecordMapper.selectByExample(appointmentRecordExample);
        if(appointmentRecords.size()>0){
            for (AppointmentRecord appointmentRecord:appointmentRecords
                 ) {
                cidIna.add(appointmentRecord.getCid());
            }
        }
        ComputerExample computerExample=new ComputerExample();
        computerExample.createCriteria().andCidNotIn(cidIna);
        List<Computer> computers=computerMapper.selectByExample(computerExample);
        if(computers.size()>0){
            for (Computer computer:computers
            ) {
                computer.setCstatus(1);
                computerMapper.updateByPrimaryKeySelective(computer);
            }
        }
    }
}
