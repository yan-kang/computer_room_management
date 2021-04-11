package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.service.CommonService;
import com.kang.computer_room_management.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ComputerController {
    final ComputerService computerService;
    final CommonService commonService;

    @Autowired
    public ComputerController(ComputerService computerService, CommonService commonService) {
        this.computerService = computerService;
        this.commonService = commonService;
    }
}
