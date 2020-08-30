package com.example.exception;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author suYan
 * @Date 2020/7/9 12:45
 * 面向切面编程，将CustomException转换成ModelViewException抛出
 * @ModelView 为切入点
 */

@Aspect
@Component
@Slf4j
public class ModelViewAspect {

    // 设置切入点，直接拦截被@ModelView注解的方法
    @Pointcut("@annotation(com.example.exception.ModelView)")
    public void pointcut() {}

    // 当有@ModelView注解的方法抛出异常时，做如下处理
    @AfterThrowing(pointcut = "pointcut()", throwing = "e")
    public void afterThrowable(Throwable e) {
        log.info("切面发生了异常", e);
        if (e instanceof CustomException) {
            throw ModelViewException.transfer((CustomException) e);
        }
    }
}
