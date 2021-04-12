package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.Computer;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IComputerService {
    List<Computer> findComputers(Computer computer);
    void setComputerStatusUp(int cid);
    void setComputerStatusDown(int cid);
    int freeComputerInRoom(int roomId);
    String showComputers(HttpServletRequest httpServletRequest);
    String showComputersPage(Model model,HttpServletRequest httpServletRequest);
    String chooseComputers(int cid,HttpServletRequest httpServletRequest);
    void updateComputerStatus();
}
