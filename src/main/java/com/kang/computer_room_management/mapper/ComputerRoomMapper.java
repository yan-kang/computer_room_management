package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.ComputerRoom;
import com.kang.computer_room_management.common.domain.ComputerRoomExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ComputerRoomMapper {
    int countByExample(ComputerRoomExample example);

    int deleteByExample(ComputerRoomExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(ComputerRoom record);

    int insertSelective(ComputerRoom record);

    List<ComputerRoom> selectByExample(ComputerRoomExample example);

    ComputerRoom selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") ComputerRoom record, @Param("example") ComputerRoomExample example);

    int updateByExample(@Param("record") ComputerRoom record, @Param("example") ComputerRoomExample example);

    int updateByPrimaryKeySelective(ComputerRoom record);

    int updateByPrimaryKey(ComputerRoom record);
}