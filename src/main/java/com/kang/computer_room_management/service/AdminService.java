package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AdminMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import com.kang.computer_room_management.mapper.StUserMapper;
import com.kang.computer_room_management.mapper.UsageRecordMapper;
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
public class AdminService implements IAdminService {
    Utils utils=new Utils();
    final AdminMapper adminMapper;
    final IComputerService computerService;
    final IComputerRoomService computerRoomService;
    final ComputerRoomMapper computerRoomMapper;
    final UsageRecordMapper usageRecordMapper;
    final StUserMapper stUserMapper;
    @Autowired
    public AdminService(AdminMapper adminMapper, IComputerService computerService, IComputerRoomService computerRoomService, ComputerRoomMapper computerRoomMapper, UsageRecordMapper usageRecordMapper, StUserMapper stUserMapper) {
        this.adminMapper = adminMapper;
        this.computerService = computerService;
        this.computerRoomService = computerRoomService;
        this.computerRoomMapper = computerRoomMapper;
        this.usageRecordMapper = usageRecordMapper;
        this.stUserMapper = stUserMapper;
    }

    @Override
    public Admin login(Admin admin) {
        //查询传入用户名是否存在
        AdminExample adminExample=new AdminExample();
        adminExample.createCriteria().andAnameEqualTo(admin.getAname());
        List<Admin> admins=adminMapper.selectByExample(adminExample);
        return admins.size()>0?admins.get(0):null;//如果admins集合有元素，则返回第一个admin对象
    }

    @Override
    public String admin(HttpServletRequest httpServletRequest, Model model) {
        HttpSession httpSession=httpServletRequest.getSession();
        boolean isLogin;
        Utils utils = new Utils();
        if(httpSession.getAttribute("uname")==null||(httpSession.getAttribute("type")).equals("user")){
            isLogin=false;
        }
        else {
            isLogin=true;
            model.addAttribute("uname",httpSession.getAttribute("uname"));
            showIndex(model, utils, computerRoomService, computerRoomMapper, computerService);
        }
        return isLogin?"admin/aindex":"redirect:/login";
    }

    @Override
    public String resetPassword(HttpServletRequest httpServletRequest) {
        int code;
        HttpSession httpSession=httpServletRequest.getSession();
        if(utils.isAdminLogin(httpServletRequest)){
            String psswd=httpServletRequest.getParameter("upsswd");
            String newPsswd=httpServletRequest.getParameter("newPsswd");
            int aid=(int)httpSession.getAttribute("uid");
            Admin admin=adminMapper.selectByPrimaryKey(aid);
            if(admin.getApsswd().equals(utils.toMd5HashString(psswd))){
                admin.setApsswd(utils.toMd5HashString(newPsswd));
                adminMapper.updateByPrimaryKeySelective(admin);
                code=1;
            }else {
                code=0;
            }
        }else {
            code=-1;
        }
        return "{\"code\":"+code+"}";
    }

    @Override
    public String feeSettlement(HttpServletRequest httpServletRequest) {
        int code;
        if(utils.isAdminLogin(httpServletRequest)){
            int id= Integer.parseInt(httpServletRequest.getParameter("id"));
            UsageRecord usageRecord=usageRecordMapper.selectByPrimaryKey(id);
            usageRecord.setStatus(3);
            usageRecordMapper.updateByPrimaryKeySelective(usageRecord);
            code=1;
        }else {
            code=0;
        }
        return "{\"code\":"+code+"}";
    }

    @Override
    public String queryUnfeeOrder(HttpServletRequest httpServletRequest) {
        int code;
        int arr = 0;
        JSONArray jsonArray=new JSONArray();
        String aname= (String) httpServletRequest.getSession().getAttribute("uname");
        if(utils.isAdminLogin(httpServletRequest)){
            code=1;
            UsageRecordExample usageRecordExample=new UsageRecordExample();
            usageRecordExample.createCriteria().andStatusEqualTo(2);
            List<UsageRecord> usageRecords=usageRecordMapper.selectByExample(usageRecordExample);
            if(usageRecords.size()>0){
                arr=1;
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                for (UsageRecord u:usageRecords
                     ) {
                    JSONObject jsonObject=new JSONObject();
                    String time=simpleDateFormat.format(u.getStartTime());
                    String uname=stUserMapper.selectByPrimaryKey(u.getUid()).getUname();
                    String cost= String.valueOf(u.getCost());
                    String rid=utils.ridToShowId(u.getRid());
                    String id= String.valueOf(u.getId());
                    jsonObject.put("datetime",time);
                    jsonObject.put("uname",uname);
                    jsonObject.put("cost",cost);
                    jsonObject.put("rid",rid);
                    jsonObject.put("id",id);
                    jsonArray.put(jsonObject);
                }
            }
        }else {
            arr=0;
            code=0;
        }
        return "{\"code\":"+code+",\"orderList\":"+jsonArray+",\"arr\":"+arr+",\"aname\":\""+aname+"\"}";
    }


    static void showIndex(Model model, Utils utils, IComputerRoomService computerRoomService, ComputerRoomMapper computerRoomMapper, IComputerService computerService) {
        computerRoomService.updateRoomStatus();
        computerRoomService.showRooms();
        List<RoomShow> roomShowList=new ArrayList<>();
        for(int i=1;i<21;i++){
            RoomShow roomShow = new RoomShow();
            ComputerRoom computerRoom= computerRoomMapper.selectByPrimaryKey(i);
            roomShow.setPath("images/pic0"+computerRoom.getRstatus()+".jpg");
            roomShow.setShowId((utils.returnValueBy(i,3))+"0" + (i%3>0?i%3:3));
            roomShow.setStyle("style"+computerRoom.getRstatus());
            roomShow.setRid(computerRoom.getRid());
            if(computerRoom.getRstatus()==2){
                roomShow.setDescription(utils.getDescription(computerRoom.getRstatus())+ computerService.freeComputerInRoom(i)+"个");
            }
            else {
                roomShow.setDescription(utils.getDescription(computerRoom.getRstatus()));
            }
            roomShowList.add(roomShow);
        }
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        simpleDateFormat.applyPattern("MM月dd日 HH:mm:ss");
        model.addAttribute("time",simpleDateFormat.format(date));
        model.addAttribute(roomShowList);
    }
}
