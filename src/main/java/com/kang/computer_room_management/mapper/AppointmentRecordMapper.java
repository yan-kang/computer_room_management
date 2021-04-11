package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.AppointmentRecord;
import com.kang.computer_room_management.common.domain.AppointmentRecordExample;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AppointmentRecordMapper {
    int countByExample(AppointmentRecordExample example);

    int deleteByExample(AppointmentRecordExample example);

    int deleteByPrimaryKey(Date reqdate);

    int insert(AppointmentRecord record);

    int insertSelective(AppointmentRecord record);

    List<AppointmentRecord> selectByExample(AppointmentRecordExample example);

    AppointmentRecord selectByPrimaryKey(Date reqdate);

    int updateByExampleSelective(@Param("record") AppointmentRecord record, @Param("example") AppointmentRecordExample example);

    int updateByExample(@Param("record") AppointmentRecord record, @Param("example") AppointmentRecordExample example);

    int updateByPrimaryKeySelective(AppointmentRecord record);

    int updateByPrimaryKey(AppointmentRecord record);
}