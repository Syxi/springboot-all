package com.su.bean;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * student
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    private Integer id;

    private String name;

    private Integer age;

    private String sex;


    private static final long serialVersionUID = 1L;
}