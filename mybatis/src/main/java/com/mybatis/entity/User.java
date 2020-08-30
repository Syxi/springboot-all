package com.mybatis.entity;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * user
 * @author 
 */
@Data
public class User implements Serializable {

    // 用户id
    private Integer id;

    // 用户姓名
    private String userName;

    // 性别
    private String sex;

    // 手机号码
    private Integer tel;

    // 从用户角度查询，一个用户可以买多个商品，一对多查询
    private List<Goods> goods;

    private static final long serialVersionUID = 1L;


}