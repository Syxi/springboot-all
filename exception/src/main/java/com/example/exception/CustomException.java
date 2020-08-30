package com.example.exception;

import com.example.exception.CustomExceptionType;

/**
 * @Author suYan
 * @Date 2020/7/8 21:26
 * 必须把项目中出现的异常转换成自定义异常抛出去
 */

public class CustomException extends RuntimeException {
    // 异常错误编码
    private int code;
    // 异常信息描述
    private String message;

    private CustomException() {}

    public CustomException(CustomExceptionType exceptionTypeEnum) {
        this.code = exceptionTypeEnum.getCode();
        this.message = exceptionTypeEnum.getTypeDesc();
    }

    public CustomException(CustomExceptionType exceptionTypeEnum, String message) {
        this.code = exceptionTypeEnum.getCode();
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
