package com.su.mapper;

import com.su.bean.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);

    Student selectByName(String name);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}