package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.UsageRecord;
import com.kang.computer_room_management.common.domain.UsageRecordExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UsageRecordMapper {
    int countByExample(UsageRecordExample example);

    int deleteByExample(UsageRecordExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(UsageRecord record);

    int insertSelective(UsageRecord record);

    List<UsageRecord> selectByExample(UsageRecordExample example);

    UsageRecord selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") UsageRecord record, @Param("example") UsageRecordExample example);

    int updateByExample(@Param("record") UsageRecord record, @Param("example") UsageRecordExample example);

    int updateByPrimaryKeySelective(UsageRecord record);

    int updateByPrimaryKey(UsageRecord record);
}