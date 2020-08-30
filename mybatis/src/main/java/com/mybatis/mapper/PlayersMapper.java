package com.mybatis.mapper;

import com.mybatis.entity.Players;

import java.util.List;

public interface PlayersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Players record);

    int insertSelective(Players record);

    Players selectByPrimaryKey(Integer id);

    List<Players> selectAll();
    int updateByPrimaryKeySelective(Players record);

    int updateByPrimaryKey(Players record);
}