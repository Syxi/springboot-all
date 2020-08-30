package com.example.aop;

public interface AopMapper {
    /** int deleteByPrimaryKey(Integer id);

    int insert(Aop record);

    int insertSelective(Aop record);

    Aop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Aop record);

    int updateByPrimaryKey(Aop record); */

    void saveLog(Aop aop);
}