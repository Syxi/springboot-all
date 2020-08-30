package com.su.config;

import lombok.Data;

/**
 * @Author suYan
 * @Date 2020/6/16 0:59
 *  统一规范接口的响应的返回数据结构
 */

@Data
public class AjaxResponse {
    // 请求是否成功
    private boolean ok;
    // 请求响应状态码
    private int code;
    // 请求结果描述数据
    private String message;
    // 请求结果数据
    private Object data;

    private AjaxResponse() {}

    // 请求处理成功的响应，不带查询数据
    public static AjaxResponse success() {
        AjaxResponse ajaxResponse = new AjaxResponse();
             ajaxResponse.setOk(true);
             ajaxResponse.setCode(200);
             ajaxResponse.setMessage("请求响应成功");
             return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object obj){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setOk(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage("请求响应成功!");
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object obj,String message){
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setOk(true);
        ajaxResponse.setCode(200);
        ajaxResponse.setMessage(message);
        ajaxResponse.setData(obj);
        return ajaxResponse;
    }
}
