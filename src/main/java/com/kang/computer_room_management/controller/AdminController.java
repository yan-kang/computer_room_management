package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.IAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    final private IAdminService adminService;
    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest httpServletRequest, Model model){
        return adminService.admin(httpServletRequest, model);
    }

    @ResponseBody
    @RequestMapping("/resetPassword")
    public String resetPassword(HttpServletRequest httpServletRequest){
        return adminService.resetPassword(httpServletRequest);
    }

    @RequestMapping("/feePage")
    public String feePage(){
        return "feeSettlement";
    }
    @ResponseBody
    @RequestMapping("/feeSettlement")
    public String feeSettlement(HttpServletRequest httpServletRequest){
        return adminService.feeSettlement(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/queryUnfeeOrder")
    public String queryUnfeeOrder(HttpServletRequest httpServletRequest){
        return adminService.queryUnfeeOrder(httpServletRequest);
    }
}

