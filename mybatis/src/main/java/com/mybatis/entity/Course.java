package com.mybatis.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * course
 * @author 
 */
@Data
public class Course implements Serializable {
    private Integer id;

    private String courseName;

    private List<Student> students;

    private static final long serialVersionUID = 1L;
}