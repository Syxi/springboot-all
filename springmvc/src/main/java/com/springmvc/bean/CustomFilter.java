package com.springmvc.bean;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @Author suYan
 * @Date 2020/6/21 20:13
 * 过滤器 对http请求到达服务器之前或响应客户端之前进行预先处理
 */
// 注册器名称为customFilter，拦截的url为所有
@WebFilter(filterName = "customFilter", urlPatterns = "/*")
@Slf4j
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Filter 的初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        log.info("customFilter 请求处理之前");
        // 对request response 进行一些预处理
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        // 链路，直接传给下一个过滤器
        filterChain.doFilter(servletRequest, servletResponse);

        log.info("cusFilter请求处理之后");
    }

    @Override
    public void destroy() {
        log.info("Filter 的销毁");
    }
}
