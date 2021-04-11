package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.IAdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}

