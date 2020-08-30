package com.su.service.impl;

import com.su.bean.Student;
import com.su.service.StudentService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class StudentServiceImplTest {

    @Autowired
    StudentService studentService;

    @Test
    void findStudentByName() {
       Student student = studentService.findStudentByName("苏卡");
        Assertions.assertThat(student.toString()).as("通过名字查询")
                .isEqualTo("Student(id=5, name=苏卡, age=22, sex=男)");

    }

    @Test
    void addStudent() {
        Student student = new Student(6,"苏测试", 22, "男");
        studentService.addStudent(student);
    }
}