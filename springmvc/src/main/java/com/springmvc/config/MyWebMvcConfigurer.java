package com.springmvc.config;

import com.springmvc.bean.CustomHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author suYan
 * @Date 2020/6/22 23:15
 * 实现WebMvcConfigurer接口完成拦截器的注册
 */

public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截器注册 拦截器的拦截规则
        // 多个拦截器时，以添加拦截器的顺序执行
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/*");
    }

    @Bean
    public static HandlerInterceptor getHandlerInterceptor() {
        return new CustomHandlerInterceptor();
    }
}
