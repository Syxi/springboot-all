package com.actuator.controller;

import com.actuator.bean.Student;
import com.actuator.server.StudentServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author suYan
 * @Date 2020/7/2 17:03
 */

@RestController
public class StudentController {
    @Autowired
    StudentServer studentServer;

    @GetMapping("/get/students")
    public Student getStudent() {
        return studentServer.selectById(3);
    }
}
