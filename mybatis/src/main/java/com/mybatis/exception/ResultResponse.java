package com.mybatis.exception;

import lombok.Data;

import java.util.Collection;

/**
 * @Author suYan
 * @Date 2020/5/7 16:19
 *  定义统一响应数据结构
 */
@Data
public class ResultResponse<T> {
    // 状态码，200表示请求成功，400表示用户操作导致异常，500表示系统异常，999其他异常
    private int code;
    // 请求结果提示信息
    private String message;
    // 请求成功后，把查询数据响应给前端
    private T data;

    private ResultResponse() {

    }

    // 请求处理出现异常时的响应数据封装
    public static ResultResponse error(int code, String message) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(code);
        resultResponse.setMessage(message);
        return resultResponse;
    }

    // 请求处理成功的响应数据封装
    public static ResultResponse success() {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(200);
        resultResponse.setMessage("success");
        return resultResponse;
    }

    // 请求处理成功，并携带数据响应
    public static ResultResponse success(Collection data) {
        ResultResponse resultResponse = new ResultResponse();
        resultResponse.setCode(200);
        resultResponse.setMessage("success");
        resultResponse.setData(data);
        return resultResponse;
    }

}
