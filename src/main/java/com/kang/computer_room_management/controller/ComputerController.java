package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.ICommonService;
import com.kang.computer_room_management.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ComputerController {
    final IComputerService computerService;
    final ICommonService commonService;

    @Autowired
    public ComputerController(IComputerService computerService, ICommonService commonService) {
        this.computerService = computerService;
        this.commonService = commonService;
    }

    @ResponseBody
    @RequestMapping("/queryComputers")
    public String queryComputers(@RequestParam("rid") Integer rid, HttpServletRequest httpServletRequest){
        return computerService.queryComputersIn(rid,httpServletRequest);
    }
    @ResponseBody
    @RequestMapping("/showComputers")
    public String showComputers(HttpServletRequest httpServletRequest){
        return computerService.showComputers(httpServletRequest);
    }
    @RequestMapping("/showComputersPage")
    public String showComputersPage(Model model){
        return computerService.showComputersPage(model);
    }
}
