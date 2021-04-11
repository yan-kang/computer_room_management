package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    final private IUserService userService;
    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping("/loginAction")
    public String loginAction(Model model, HttpServletRequest httpServletRequest){
        return userService.loginServer(httpServletRequest, model);
    }
    //退出登录
    @RequestMapping("/logOut")
    public String logOut(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping("/registerAction")
    public String registerAction(HttpServletRequest httpServletRequest, Model model){
        return userService.register(httpServletRequest, model);
    }

    @RequestMapping("/register")
    public String registerPage(){
        return "register";
    }

    @ResponseBody
    @RequestMapping("/checkName")
    public String checkName(@RequestParam("uname") String uname){
        StUser stUser=new StUser();
        stUser.setUname(uname);
        int isExist=1;
        if(userService.login(stUser)==null){
            isExist=0;
        }
        else {
            isExist=1;
        }
        return "{\"isExist\":"+isExist+"}";
    }
}
