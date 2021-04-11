package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.ComputerRoom;

import java.util.List;

public interface IComputerRoomService {
    List<ComputerRoom> findRoomsAs(ComputerRoom computerRoom);
    void updateRoomStatus();
    void showRooms();
}
