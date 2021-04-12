package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.Computer;
import com.kang.computer_room_management.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppointmentController {

    final IComputerService computerService;
    @Autowired
    public AppointmentController(IComputerService computerService) {
        this.computerService = computerService;
    }


//    @RequestMapping("/结算")
//    public String unAppoint(Model model,Computer computer){
//        computerService.setComputerStatusUp(computer);
//        model.addAttribute(computer);
//        model.addAttribute("num",computer.getCid()%30>0?computer.getCid()%30:30);
//        return "unAppointResult";
//    }
}
