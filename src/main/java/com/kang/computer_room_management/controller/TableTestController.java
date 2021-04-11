package com.kang.computer_room_management.controller;

import com.kang.computer_room_management.common.domain.TableTest;
import com.kang.computer_room_management.service.TableTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TableTestController {

    final TableTestService tableTestService;
    @Autowired
    public TableTestController(TableTestService tableTestService) {
        this.tableTestService = tableTestService;
    }
//    @RequestMapping("/")
//    public String index(){
//        return "userlogin";
//    }

    @RequestMapping("/chaxun")
    public String chaxun(Model model, TableTest tableTest){
        return tableTestService.chaxunprocess(model,tableTest);
    }
}
