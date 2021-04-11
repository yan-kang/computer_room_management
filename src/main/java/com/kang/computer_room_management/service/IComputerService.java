package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.Computer;

import java.util.List;

public interface IComputerService {
    List<Computer> findComputers(Computer computer);
    void setComputerStatusUp(Computer computer);
    void setComputerStatusDown(Computer computer);
    int freeComputerInRoom(int roomId);
}
