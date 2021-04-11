package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.Utils;
import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.common.domain.RoomShow;
import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.mapper.ComputerRoomMapper;
import com.kang.computer_room_management.mapper.StUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class CommonService implements ICommonService {
    final private IComputerRoomService computerRoomService;
    final private StUserMapper stUserMapper;
    final private ComputerRoomMapper computerRoomMapper;
    final private IComputerService computerService;
    public CommonService(IComputerRoomService computerRoomService, StUserMapper stUserMapper, ComputerRoomMapper computerRoomMapper, IComputerService computerService) {
        this.computerRoomService = computerRoomService;
        this.stUserMapper = stUserMapper;
        this.computerRoomMapper = computerRoomMapper;
        this.computerService = computerService;
    }
    Utils utils=new Utils();
    @Override
    public boolean isLogin(HttpSession httpSession) {
        try{
            if(httpSession.getAttribute("uname")==null) {
                return false;
            }
            else
            return true;
        }catch (RuntimeException e){
            utils.printLog(e);
            return false;
        }
    }

    @Override
    public String index(HttpServletRequest httpServletRequest, Model model) {
        HttpSession httpSession=httpServletRequest.getSession();
        boolean isLogin;
        if(httpSession.getAttribute("uname")==null||(httpSession.getAttribute("type")).equals("admin")){
            isLogin=false;
        }
        else {
            isLogin=true;
            model.addAttribute("uname",httpSession.getAttribute("uname"));
            StUser stUser=stUserMapper.selectByPrimaryKey((int)httpSession.getAttribute("uid"));
            model.addAttribute("uprofile",stUser.getUprofile());
            AdminService.showIndex(model, utils, computerRoomService, computerRoomMapper, computerService);
        }
        return isLogin?"index":"redirect:/login";
    }
}
