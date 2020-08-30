package com.log4j2.interceptor;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author suYan
 * @Date 2020/8/30 11:01
 * 注册拦截器
 */

public class MyWebMvcConfigurer implements WebMvcConfigurer {

    // 设置排除路径，不然静态资源无法访问
    private static String[] excludePath = {"/static"};

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册拦截器
        registry.addInterceptor(new AccessLogInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePath);
    }
}
