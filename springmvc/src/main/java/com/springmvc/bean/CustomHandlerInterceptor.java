package com.springmvc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author suYan
 * @Date 2020/6/22 22:39
 * 拦截器：
 * 1.是面向切面编程的一种应用
 * 2.面向的是servlet的方法
 * 3.在方法调用之前执行或在方法调用完成后执行,添加一些额外的增强功能
 */

@Slf4j
public class CustomHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle: 请求前调用");
        // 返回 false， 则请求中断
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle: 请求后调用");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion: 请求调用完成后回调方法，即在视图渲染完成后回调");
    }

}
