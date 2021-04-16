package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }

    @ResponseBody
    @RequestMapping(path = "/loginAction",method = RequestMethod.POST)
    public String loginAction(Model model, HttpServletRequest httpServletRequest){
        return userService.loginServer(httpServletRequest, model);
    }
    //退出登录
    @RequestMapping(path = "/logOut",method = RequestMethod.GET)
    public String logOut(HttpServletRequest httpServletRequest){
        HttpSession httpSession=httpServletRequest.getSession();
        httpSession.invalidate();
        return "redirect:/login";
    }

    @ResponseBody
    @RequestMapping(path = "/registerAction",method = RequestMethod.POST)
    public String registerAction(HttpServletRequest httpServletRequest, Model model){
        return userService.register(httpServletRequest, model);
    }

    @RequestMapping(path = "/register",method = RequestMethod.GET)
    public String registerPage(){
        return "register";
    }

    @ResponseBody
    @RequestMapping(path = "/checkName",method = RequestMethod.GET)
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

    @ResponseBody
    @RequestMapping(path = "/resetInfo",method = RequestMethod.PUT)
    public String resetInfo(HttpServletRequest httpServletRequest){
        return userService.resetInfo(httpServletRequest);
    }
}
