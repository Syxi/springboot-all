package com.example.aop;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * aop
 * @author 
 */
@Data
public class Aop implements Serializable {

    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 响应时间
     */
    private Integer time;

    /**
     * 请求方法
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 创建时间
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}