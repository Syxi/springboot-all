package com.mybatis.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * student
 * @author 
 */
@Data
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;

    // 多对多查询
    private List<Course> courses;

    private static final long serialVersionUID = 1L;

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student( String sex, Integer id) {
        this.id = id;
        this.sex = sex;
    }

    public Student() {
    }

    public Student(Integer id, String name, Integer age, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
}