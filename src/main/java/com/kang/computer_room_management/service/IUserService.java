package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.StUser;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    StUser login(StUser stUser);
    String loginServer(HttpServletRequest httpServletRequest, Model model);
    String register(HttpServletRequest httpServletRequest,Model model);
    String resetInfo(HttpServletRequest httpServletRequest);
}
