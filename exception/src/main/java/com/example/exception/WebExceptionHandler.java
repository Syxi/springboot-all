package com.example.exception;


import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author suYan
 * @Date 2020/7/9 13:09
 * 全局异常处理
 */

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(ModelViewException.class)
    public ModelAndView viewExceptionHandler(HttpServletRequest request, ModelViewException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURI());
        modelAndView.setViewName("error");
        return modelAndView;
    }

    // 处理程序员主动转换的自定义异常
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ResultBean customException(CustomException e) {
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {

        }
        return ResultBean.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean exception(Exception e) {
        return ResultBean.error(new CustomException(CustomExceptionType.OTHER_ERROR, "未知异常"));
    }

    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean bindException(BindException e) {
        FieldError fieldError = e.getBindingResult().getFieldError();
        return ResultBean.error(new CustomException(CustomExceptionType.USER_INPUT_ERROR, fieldError.getDefaultMessage()));
    }


}
