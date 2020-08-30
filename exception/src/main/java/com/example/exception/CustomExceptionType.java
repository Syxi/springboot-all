package com.example.exception;

/**
 * @Author suYan
 * @Date 2020/7/8 16:19
 *  枚举异常分类，将异常分类固定下来，防止开发人员各自定义异常类型
 */
public enum CustomExceptionType {
    // 异常分类编码和异常分类描述
    USER_INPUT_ERROR(400, "您输入的数据错误或您没有权限访问资源"),
    SYSTEM_ERROR(500, "系统出现异常，请您稍后再试"),
    OTHER_ERROR(999, "系统出现未知异常，请您联系管理员");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    private int code;
    private String typeDesc; // 异常类型中文描述

    public int getCode() {
        return code;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
