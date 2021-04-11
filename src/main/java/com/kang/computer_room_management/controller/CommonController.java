package com.kang.computer_room_management.controller;
import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
public class CommonController {
    final private ICommonService commonService;
    @Autowired
    public CommonController(ICommonService commonService) {
        this.commonService = commonService;
    }

    @RequestMapping("/")
    public String index(HttpServletRequest httpServletRequest, Model model) {
        return commonService.index(httpServletRequest, model);
    }


}
