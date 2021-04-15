package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.Admin;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface IAdminService {
    Admin login(Admin admin);
    String admin(HttpServletRequest httpServletRequest, Model model);
    String resetPassword(HttpServletRequest httpServletRequest);
    String feeSettlement(HttpServletRequest httpServletRequest);
    String queryUnfeeOrder(HttpServletRequest httpServletRequest);
}
