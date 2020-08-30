package com.su.service.impl;

import com.su.bean.Student;
import com.su.mapper.StudentMapper;
import com.su.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author suYan
 * @Date 2020/6/15 20:16
 */

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
   StudentMapper studentMapper;

    @Override
    public Student findStudentByName(String name) {
        return studentMapper.selectByName(name);
    }

    @Override
    public String addStudent(Student student) {
         studentMapper.insert(student);
         return "success";
    }
}
