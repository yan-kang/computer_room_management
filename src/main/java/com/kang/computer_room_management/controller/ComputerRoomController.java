package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.service.IComputerRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ComputerRoomController {

    final private IComputerRoomService computerRoomService;
    @Autowired
    public ComputerRoomController(IComputerRoomService computerRoomService) {
        this.computerRoomService = computerRoomService;
    }

    @ResponseBody
    @RequestMapping(path = "/chooseRoom",method = RequestMethod.POST)
    public String chooseRoom(HttpServletRequest httpServletRequest){
        return computerRoomService.chooseRoom(httpServletRequest);
    }
    @ResponseBody
    @RequestMapping(path = "/queryComputerRooms",method = RequestMethod.GET)
    public String queryRoomStatusBy(@RequestParam("rid") Integer rid, HttpServletRequest httpServletRequest){
        return computerRoomService.queryRoomStatusBy(rid,httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/admin/refreshInfo",method = RequestMethod.GET)
    public String refreshInfo(HttpServletRequest httpServletRequest){
        return computerRoomService.refreshInfo(httpServletRequest);
    }
}
