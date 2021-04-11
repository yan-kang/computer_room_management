package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.service.IComputerRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ComputerRoomController {

    final private IComputerRoomService computerRoomService;
    @Autowired
    public ComputerRoomController(IComputerRoomService computerRoomService) {
        this.computerRoomService = computerRoomService;
    }

    @RequestMapping("/showroom")
    public String showRoom(Model model, ComputerRoom computerRoom, HttpServletRequest httpServletRequest){
        computerRoom.getRstatus();
        System.out.println(httpServletRequest.getAttribute("id"));
        System.out.println(httpServletRequest.getAttribute("rid"));
        System.out.println(computerRoom.getRid());
        List<ComputerRoom> computerRoomList=computerRoomService.findRoomsAs(computerRoom);
        model.addAttribute(computerRoomList);
        System.out.println("!");
        return "showRoom";
    }
}
