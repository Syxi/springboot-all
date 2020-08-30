package com.example.exception;

/**
 * @Author suYan
 * @Date 2020/7/9 12:19
 * 处理页面模板时，controller发生异常，需要跳转到error.html页面
 * 1.用面向切面的方式，将CustomException转换为ModelAndViewException。
 * 2.全局异常处理器拦截ModelAndViewException，返回ModelAndView，即error.html页面
 * 3.切入点是带@ModelView注解的Controller层方法
 */

public class ModelViewException extends RuntimeException {
    // 异常错误编码
    private int code;
    // 异常信息
    private String message;

    public static ModelViewException transfer(CustomException e) {
        return new ModelViewException(e.getCode(), e.getMessage());
    }

    private ModelViewException(int code, String message) {
        this.code = code;
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
