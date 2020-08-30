package com.example.exception;

import lombok.Data;

/**
 * @Author suYan
 * @Date 2020/7/8 21:35
 * 接口数据请求统一响应数据结构
 */

@Data
public class ResultBean {

    // 请求是否处理成功
    private boolean ok;
    // 请求响应状态码
    private int code;
    // 请求结果描述信息
    private String message;
    // 请求结果数据
    private Object data;

    private ResultBean() {}

    // 请求出现异常时的响应数据封装
    public static ResultBean error(CustomException e) {
        ResultBean resultBean = new ResultBean();
        resultBean.setOk(false);
        resultBean.setCode(e.getCode());
        resultBean.setMessage(e.getMessage());
        return resultBean;
    }


    // 请求出现异常时的响应数据封装
    public static ResultBean error(CustomExceptionType customExceptionType, String errorMessage) {
        ResultBean resultBean = new ResultBean();
        resultBean.setOk(false);
        resultBean.setCode(customExceptionType.getCode());
        resultBean.setMessage(errorMessage);
        return resultBean;
    }

    // 请求成功响应，不带查询数据（用于查询、修改、新增接口）
    public static ResultBean success() {
        ResultBean resultBean = new ResultBean();
        resultBean.setOk(true);
        resultBean.setCode(200);
        resultBean.setMessage("请求响应成功");
        return resultBean;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResultBean success(Object data) {
        ResultBean resultBean = new ResultBean();
        resultBean.setOk(true);
        resultBean.setCode(200);
        resultBean.setMessage("请求响应成功");
        resultBean.setData(data);
        return resultBean;
    }

    // 请求成功的响应，带有查询数据（用于数据查询接口）
    public static ResultBean success(Object data, String message) {
        ResultBean resultBean = new ResultBean();
        resultBean.setOk(true);
        resultBean.setCode(200);
        resultBean.setMessage(message);
        resultBean.setData(data);
        return resultBean;
    }
}
