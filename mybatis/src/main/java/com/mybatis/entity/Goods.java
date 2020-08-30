package com.mybatis.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * goods
 * @author 
 */
@Data
public class Goods implements Serializable {

    private Integer id;

    private String goodsName;

    private Integer goodsNumber;

    // 商品总额
    private Double amount;

    // 从商品的角度查询，一件商品属于一个用户， 一对一查询
    private User user;

    private static final long serialVersionUID = 1L;
}