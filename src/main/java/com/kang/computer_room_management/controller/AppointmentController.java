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

    @RequestMapping("/dealHistory")
    public String dealHistory(){
        return "dealHistory";
    }
    @ResponseBody
    @RequestMapping("/showDealHistory")
    public String showDealHistory(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showDealHistory(httpServletRequest);
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

    @ResponseBody
    @RequestMapping("/startUseComputer")
    public String startUseComputer(HttpServletRequest httpServletRequest){
        return appointmentRecordService.startUseComputer(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/cancelComputerAppoint")
    public String cancelComputerAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.cancelComputerAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/useInfo")
    public String useInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.useInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/endUseComputer")
    public String endUseComputer(HttpServletRequest httpServletRequest){
        return appointmentRecordService.endUseComputer(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/resetAppointInfo")
    public String resetAppointInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.resetAppointInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/cancelRoomAppoint")
    public String cancelRoomAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.cancelRoomAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/startUseRoom")
    public String startUseRoom(HttpServletRequest httpServletRequest){
        return appointmentRecordService.startUseRoom(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/showInfo")
    public String showInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/endUseRoom")
    public String endUseRoom(HttpServletRequest httpServletRequest){
        return appointmentRecordService.endUseRoom(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/showAppoint")
    public String showAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/dealAppoint")
    public String dealAppoint(HttpServletRequest httpServletRequest){
        return  appointmentRecordService.dealAppoint(httpServletRequest);
    }
}
