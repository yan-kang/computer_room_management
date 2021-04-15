package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.ComputerRoom;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IComputerRoomService {
    List<ComputerRoom> findRoomsAs(ComputerRoom computerRoom);
    void updateRoomStatus();
    void showRooms();
    String chooseRoom(HttpServletRequest httpServletRequest);
    String queryRoomStatusBy(Integer rid, HttpServletRequest httpServletRequest);
    String refreshInfo(HttpServletRequest httpServletRequest);
}
