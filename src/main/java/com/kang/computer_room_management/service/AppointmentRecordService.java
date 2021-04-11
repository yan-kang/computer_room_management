package com.kang.computer_room_management.service;

import com.kang.computer_room_management.common.domain.*;
import com.kang.computer_room_management.mapper.AppointmentRecordMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentRecordService implements IAppointmentRecordService {

    final private AppointmentRecordMapper appointmentRecordMapper;
    @Autowired
    public AppointmentRecordService(AppointmentRecordMapper appointmentRecordMapper) {
        this.appointmentRecordMapper = appointmentRecordMapper;
    }

    @Override
    public List<Integer> findRidInAppointment() {
        //查找在预约表且状态为0的机房id
        List<Integer> ridInA=new ArrayList<>();
        AppointmentRecordExample appointmentRecordExample=new AppointmentRecordExample();
        appointmentRecordExample.createCriteria().andArstatusEqualTo(0);
        List<AppointmentRecord> appointmentRecords=appointmentRecordMapper.selectByExample(appointmentRecordExample);
        for(AppointmentRecord appointmentRecord:appointmentRecords)
            ridInA.add(appointmentRecord.getRid());
        return ridInA.size()>0?ridInA:null;
    }

    @Override
    public void setComputerAppointmentRecord(StUser stUser, Computer computer) {

    }

    @Override
    public void setRoomAppointmentRecord(StUser stUser, ComputerRoom computerRoom) {

    }

    @Override
    public void dealAppointmentRecord(Admin admin, ComputerRoom computerRoom) {

    }
}
