package com.kang.computer_room_management.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public interface ICommonService {

    String index(HttpServletRequest httpServletRequest, Model model);

}
