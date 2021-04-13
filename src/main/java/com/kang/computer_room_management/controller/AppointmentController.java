package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.IAppointmentRecordService;
import com.kang.computer_room_management.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AppointmentController {

    final IComputerService computerService;
    final IAppointmentRecordService appointmentRecordService;
    @Autowired
    public AppointmentController(IComputerService computerService, IAppointmentRecordService appointmentRecordService) {
        this.computerService = computerService;
        this.appointmentRecordService = appointmentRecordService;
    }


//    @RequestMapping("/结算")
//    public String unAppoint(Model model,Computer computer){
//        computerService.setComputerStatusUp(computer);
//        model.addAttribute(computer);
//        model.addAttribute("num",computer.getCid()%30>0?computer.getCid()%30:30);
//        return "unAppointResult";
//    }
    @RequestMapping("/historyPage")
    public String historyPage(){
        return "history";
    }
    @ResponseBody
    @RequestMapping("/showHistory")
    public String showHistory(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showHistory(httpServletRequest);
    }

    @RequestMapping("/appointmentPage")
    public String appointmentPage(){
        return "appointment";
    }
    @ResponseBody
    @RequestMapping("/showAppointment")
    public String showAppointment(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showAppointment(httpServletRequest);
    }
}
