package com.kang.computer_room_management.mapper;

import com.kang.computer_room_management.common.domain.StUser;
import com.kang.computer_room_management.common.domain.StUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface StUserMapper {
    int countByExample(StUserExample example);

    int deleteByExample(StUserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(StUser record);

    int insertSelective(StUser record);

    List<StUser> selectByExample(StUserExample example);

    StUser selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByExample(@Param("record") StUser record, @Param("example") StUserExample example);

    int updateByPrimaryKeySelective(StUser record);

    int updateByPrimaryKey(StUser record);
}