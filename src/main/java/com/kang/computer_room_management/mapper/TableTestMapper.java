package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.TableTest;
import com.kang.computer_room_management.common.domain.TableTestExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TableTestMapper {
    int countByExample(TableTestExample example);

    int deleteByExample(TableTestExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TableTest record);

    int insertSelective(TableTest record);

    List<TableTest> selectByExample(TableTestExample example);

    TableTest selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TableTest record, @Param("example") TableTestExample example);

    int updateByExample(@Param("record") TableTest record, @Param("example") TableTestExample example);

    int updateByPrimaryKeySelective(TableTest record);

    int updateByPrimaryKey(TableTest record);
}