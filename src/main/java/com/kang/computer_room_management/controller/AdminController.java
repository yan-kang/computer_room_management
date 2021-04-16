package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.IAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    final private IAdminService adminService;
    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping(path="/admin", method = RequestMethod.GET)
    public String admin(HttpServletRequest httpServletRequest, Model model){
        return adminService.admin(httpServletRequest, model);
    }

    @ResponseBody
    @RequestMapping(path="/admin/resetPassword",method = RequestMethod.PUT)
    public String resetPassword(HttpServletRequest httpServletRequest){
        return adminService.resetPassword(httpServletRequest);
    }

    @RequestMapping(path = "/admin/feePage",method = RequestMethod.GET)
    public String feePage(){
        return "admin/feeSettlement";
    }
    @ResponseBody
    @RequestMapping(path = "/admin/feeSettlement",method = RequestMethod.PUT)
    public String feeSettlement(HttpServletRequest httpServletRequest){
        return adminService.feeSettlement(httpServletRequest);
    }

    @ResponseBody
    @RequestMapping(path = "/admin/queryUnfeeOrder",method = RequestMethod.GET)
    public String queryUnfeeOrder(HttpServletRequest httpServletRequest){
        return adminService.queryUnfeeOrder(httpServletRequest);
    }
}

