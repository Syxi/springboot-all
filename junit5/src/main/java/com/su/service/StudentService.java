package com.su.service;

import com.su.bean.Student;
import org.springframework.stereotype.Service;

/**
 * @Author suYan
 * @Date 2020/6/15 19:57
 */


public interface StudentService {

    Student findStudentByName(String name);
    String addStudent(Student student);
}
