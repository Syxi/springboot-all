package com.log4j2.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author suYan
 * @Date 2020/8/30 10:20
 * 记录用户访问操作日志
 *
 * 针对当前系统的每一次接口访问，要记录是什么人访问的（用户名）、什么时间访问的、
 * 访问耗时多长时间、使用什么HTTP method方法访问的、访问结果如何等。可以称为审计日志。
 * 将访问记录审计日志，输出到一个单独的日志文件access.log
 */

@Data
public class AccessLog {
    //访问者用户名
    private String username;
    //请求路径
    private String url;
    //请求消耗时长
    private Integer duration;
    //http 方法：GET、POST等
    private String httpMethod;
    //http 请求响应状态码
    private Integer httpStatus;
    //访问者ip
    private String ip;
    //此条记录的创建时间
    private Date createTime;
}
