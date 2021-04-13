package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.Admin;
import com.kang.computer_room_management.common.domain.Computer;
import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.common.domain.StUser;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IAppointmentRecordService {
    List<Integer> findRidInAppointment();
    void setComputerAppointmentRecord(StUser stUser, Computer computer);
    void setRoomAppointmentRecord(StUser stUser, ComputerRoom computerRoom);
    void dealAppointmentRecord(Admin admin,ComputerRoom computerRoom);
    String showHistory(HttpServletRequest httpServletRequest);
    String showAppointment(HttpServletRequest httpServletRequest);
}
