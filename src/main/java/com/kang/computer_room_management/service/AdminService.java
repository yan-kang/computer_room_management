package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AdminMapper;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
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
    final AdminMapper adminMapper;
    final IComputerService computerService;
    final IComputerRoomService computerRoomService;
    final ComputerRoomMapper computerRoomMapper;
    @Autowired
    public AdminService(AdminMapper adminMapper, IComputerService computerService, IComputerRoomService computerRoomService, ComputerRoomMapper computerRoomMapper) {
        this.adminMapper = adminMapper;
        this.computerService = computerService;
        this.computerRoomService = computerRoomService;
        this.computerRoomMapper = computerRoomMapper;
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
        return isLogin?"aindex":"redirect:/login";
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
