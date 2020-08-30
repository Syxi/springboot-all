package com.mybatis.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author suYan
 * @Date 2020/5/7 21:05
 *  统一处理异常
 */
@Slf4j
@ControllerAdvice
public class WebExceptionHandler {
    @ExceptionHandler
    public String testError(ArithmeticException e, HttpServletRequest request) {
        log.error("出现了除零异常", e);
        request.setAttribute("javax.servlet.error.status_code", 500);
        request.setAttribute("code", 66);
        request.setAttribute("message", "出现了除零异常");
        return "forward:/error";
    }

    @ExceptionHandler
    public String methodArgumentNotValid(BindException e) {
        log.error("参数校验失败", e);
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        StringBuilder errorMessage = new StringBuilder();
        for (int i = 0; i < allErrors.size(); i++) {
            ObjectError error = allErrors.get(i);
            errorMessage.append(error.getDefaultMessage());
            if (i != allErrors.size() - 1) {
                errorMessage.append(", ");
            }
        }
        // do something
        return generateErrorInfo(1, errorMessage.toString(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler
    public String unknownException(Exception e) {
        log.error("发生了未知的异常", e);
        return generateErrorInfo(-999, "系统故障，请稍后再试");
    }

    // 生成错误信息，放进 request 域中
    private String generateErrorInfo(int code, String message, int httpStatus) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        request.setAttribute("code", code);
        request.setAttribute("message", message);
        request.setAttribute("javax.servlet.error.status_code", httpStatus);
        return "forward:/error";
    }

    private String generateErrorInfo(int code, String message) {
        return generateErrorInfo(code, message, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
