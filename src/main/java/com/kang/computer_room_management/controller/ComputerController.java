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
import java.util.List;

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
    @RequestMapping("/showComputers")
    public String showComputers(HttpServletRequest httpServletRequest){
        return computerService.showComputers(httpServletRequest);
    }
    @RequestMapping("/showComputersPage")
    public String showComputersPage(Model model,HttpServletRequest httpServletRequest){
        return computerService.showComputersPage(model,httpServletRequest);
    }

    @ResponseBody
    @RequestMapping("/chooseComputers")
    public String chooseComputers(@RequestParam("cid") int cid,HttpServletRequest httpServletRequest){
        return computerService.chooseComputers(cid,httpServletRequest);
    }
}
