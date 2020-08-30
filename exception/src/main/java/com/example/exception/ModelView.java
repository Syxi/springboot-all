package com.example.exception;

import java.lang.annotation.*;

/**
    ModelView注解，只起标注作用
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})  // 只能在方法上使用此注解
public @interface ModelView {
}
