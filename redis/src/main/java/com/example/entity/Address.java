package com.example.entity;

import lombok.Data;

/**
 * @Author suYan
 * @Date 2020/8/12 21:40
 */

@Data
public class Address {

    private static final long serialVersionUID = -8985545025228238754L;

    String city;
    String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }
}
