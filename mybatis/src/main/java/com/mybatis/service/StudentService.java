package com.mybatis.service;

import com.mybatis.entity.Student;

import java.util.List;


public interface StudentService {
    int deleteByPrimaryKey(Integer id);

    int insert(Student record);

    int insertSelective(Student record);

   Student selectByPrimaryKey(Integer id);

   List<Student> selectAll();

 List<Student> selectCourse(Integer id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}

