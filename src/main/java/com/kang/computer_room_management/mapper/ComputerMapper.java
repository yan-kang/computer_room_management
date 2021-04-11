package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.Computer;
import com.kang.computer_room_management.common.domain.ComputerExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ComputerMapper {
    int countByExample(ComputerExample example);

    int deleteByExample(ComputerExample example);

    int deleteByPrimaryKey(Integer cid);

    int insert(Computer record);

    int insertSelective(Computer record);

    List<Computer> selectByExample(ComputerExample example);

    Computer selectByPrimaryKey(Integer cid);

    int updateByExampleSelective(@Param("record") Computer record, @Param("example") ComputerExample example);

    int updateByExample(@Param("record") Computer record, @Param("example") ComputerExample example);

    int updateByPrimaryKeySelective(Computer record);

    int updateByPrimaryKey(Computer record);
}