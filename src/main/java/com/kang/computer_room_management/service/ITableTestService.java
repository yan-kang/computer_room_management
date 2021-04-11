package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.TableTest;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

public interface ITableTestService {
    String chaxunprocess(Model model, TableTest tableTest);
}
