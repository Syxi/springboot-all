package com.actuator.bean;

import java.io.Serializable;
import lombok.Data;

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

    private static final long serialVersionUID = 1L;
}