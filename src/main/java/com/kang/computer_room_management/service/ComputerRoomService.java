package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AppointmentRecordMapper;
import com.kang.computer_room_management.mapper.ComputerMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ComputerRoomService implements IComputerRoomService {
    final private ComputerRoomMapper computerRoomMapper;
    final private ComputerMapper computerMapper;
    final private IAppointmentRecordService appointmentRecordService;
    final private AppointmentRecordMapper appointmentRecordMapper;
    @Autowired
    public ComputerRoomService(ComputerRoomMapper computerRoomMapper, ComputerMapper computerMapper, IAppointmentRecordService appointmentRecordService, AppointmentRecordMapper appointmentRecordMapper) {
        this.computerRoomMapper = computerRoomMapper;
        this.computerMapper = computerMapper;
        this.appointmentRecordService = appointmentRecordService;
        this.appointmentRecordMapper = appointmentRecordMapper;
    }
    Utils utils=new Utils();
    @Override
    public List<ComputerRoom> findRoomsAs(ComputerRoom computerRoom) {
        //updateRoomStatus();
        ComputerRoomExample computerRoomExample=new ComputerRoomExample();
        computerRoomExample.createCriteria().andRstatusEqualTo(computerRoom.getRstatus());
        List<ComputerRoom> computerRooms=computerRoomMapper.selectByExample(computerRoomExample);
        return computerRooms.size()>0?computerRooms:null;
    }

    @Override
    public void updateRoomStatus() {
        //更新所有机房状态
        ComputerExample computerExample=new ComputerExample();
        computerExample.createCriteria().andCstatusEqualTo(0);
        List<Integer> rId=new ArrayList<Integer>();
        //找出cstatus为0的电脑所在rid集合
        for(Computer computer:computerMapper.selectByExample(computerExample)) {
            rId.add(computer.getRid());
        }
        //找到rid在集合rId里的机房，更新status为2
        ComputerRoomExample computerRoomExample=new ComputerRoomExample();
       computerRoomExample.createCriteria().andRidIn(rId);
       List<ComputerRoom> computerRooms=computerRoomMapper.selectByExample(computerRoomExample);
       for(ComputerRoom computerRoom1:computerRooms) {
           computerRoom1.setRstatus(2);
           computerRoomMapper.updateByPrimaryKey(computerRoom1);
       }
       //找到rid不在集合rId里的机房，更新status为3
       ComputerRoomExample computerRoomExample1=new ComputerRoomExample();
       computerRoomExample1.createCriteria().andRidNotIn(rId);
       List<ComputerRoom> computerRooms1=computerRoomMapper.selectByExample(computerRoomExample1);
        for(ComputerRoom computerRoom1:computerRooms1) {
            computerRoom1.setRstatus(3);
            computerRoomMapper.updateByPrimaryKey(computerRoom1);
        }
        //找到正在预约中的机房，更新status为1
        List<Integer> ridInA=appointmentRecordService.findRidInAppointment();
        if(ridInA!=null){
            ComputerRoomExample computerRoomExample2=new ComputerRoomExample();
            computerRoomExample2.createCriteria().andRidIn(ridInA);
            List<ComputerRoom> computerRooms2=computerRoomMapper.selectByExample(computerRoomExample2);
            for(ComputerRoom computerRoom1:computerRooms2){
                computerRoom1.setRstatus(1);
                computerRoomMapper.updateByPrimaryKeySelective(computerRoom1);
            }
        }
    }

    @Override
    public void showRooms() {
        //展示机房信息

    }

    @Override
    public String chooseRoom(HttpServletRequest httpServletRequest) {
        int code = 0;
        if(utils.isUserLogin(httpServletRequest)) {
            System.out.println(httpServletRequest.getParameter("reason"));
            HttpSession httpSession = httpServletRequest.getSession();
            AppointmentRecord appointmentRecord=new AppointmentRecord();
            appointmentRecord.setUid((int)httpSession.getAttribute("uid"));
            appointmentRecord.setRid((int)httpSession.getAttribute("nowRoom"));
            Date date=new Date();
            appointmentRecord.setReqdate(date);
            appointmentRecord.setArtype(0);
            appointmentRecord.setArstatus(3);
            appointmentRecordMapper.insert(appointmentRecord);
            updateRoomStatus();
            code=1;
            return "{\"code\":" + code + ",\"uname\":\"" + httpSession.getAttribute("uname") + "\"}";
        }else{
            return "{\"code\":"+code+"}";
        }
    }
    @Override
    public String queryRoomStatusBy(Integer rid, HttpServletRequest httpServletRequest) {
        int loginStaus=0;
        if(utils.isUserLogin(httpServletRequest))loginStaus=1;
        int code=(computerRoomMapper.selectByPrimaryKey(rid)).getRstatus();
        HttpSession httpSession=httpServletRequest.getSession();
        httpSession.setAttribute("nowRoom",rid);
        String showId=(utils.returnValueBy(rid,3))+"0" + (rid%3>0?rid%3:3);
        return "{\"code\":"+code+",\"showId\":\""+showId+"\",\"loginStatus\":"+loginStaus+"}";
    }

}
