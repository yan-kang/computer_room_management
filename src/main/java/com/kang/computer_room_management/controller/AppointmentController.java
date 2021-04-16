package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.IAppointmentRecordService;
import com.kang.computer_room_management.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


    @RequestMapping(path = "/historyPage",method = RequestMethod.GET)
    public String historyPage(){
        return "history";
    }
    @ResponseBody
    @RequestMapping(path = "/showHistory",method = RequestMethod.GET)
    public String showHistory(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showHistory(httpServletRequest);
    }

    @RequestMapping(path = "/dealHistory",method = RequestMethod.GET)
    public String dealHistory(){
        return "dealHistory";
    }
    @ResponseBody
    @RequestMapping(path = "/showDealHistory",method = RequestMethod.GET)
    public String showDealHistory(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showDealHistory(httpServletRequest);
    }

    @RequestMapping(path = "/appointmentPage",method = RequestMethod.GET)
    public String appointmentPage(){
        return "appointment";
    }
    @ResponseBody
    @RequestMapping(path = "/showAppointment",method = RequestMethod.GET)
    public String showAppointment(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showAppointment(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/startUseComputer",method = RequestMethod.PUT)
    public String startUseComputer(HttpServletRequest httpServletRequest){
        return appointmentRecordService.startUseComputer(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/cancelComputerAppoint",method = RequestMethod.PUT)
    public String cancelComputerAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.cancelComputerAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path="/useInfo",method = RequestMethod.GET)
    public String useInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.useInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/endUseComputer",method = RequestMethod.PUT)
    public String endUseComputer(HttpServletRequest httpServletRequest){
        return appointmentRecordService.endUseComputer(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/resetAppointInfo",method = RequestMethod.PUT)
    public String resetAppointInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.resetAppointInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/cancelRoomAppoint",method = RequestMethod.PUT)
    public String cancelRoomAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.cancelRoomAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/startUseRoom",method = RequestMethod.PUT)
    public String startUseRoom(HttpServletRequest httpServletRequest){
        return appointmentRecordService.startUseRoom(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/showInfo",method = RequestMethod.GET)
    public String showInfo(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showInfo(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/endUseRoom",method = RequestMethod.PUT)
    public String endUseRoom(HttpServletRequest httpServletRequest){
        return appointmentRecordService.endUseRoom(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/showAppoint",method = RequestMethod.GET)
    public String showAppoint(HttpServletRequest httpServletRequest){
        return appointmentRecordService.showAppoint(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/dealAppoint",method = RequestMethod.PUT)
    public String dealAppoint(HttpServletRequest httpServletRequest){
        return  appointmentRecordService.dealAppoint(httpServletRequest);
    }
}
