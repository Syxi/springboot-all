package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author suYan
 * @Date 2020/8/12 21:23
 */

@Data
public class Person implements Serializable {
    private static final long serialVersionUID = -8985545025228238754L;

    String id;
    String firstName;
    String lastName;
    Address address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
