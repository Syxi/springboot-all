package com.log4j2.interceptor;

import com.log4j2.entity.AccessLog;
import com.log4j2.util.AddressIPUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @Author suYan
 * @Date 2020/8/30 10:41
 * 自定义拦截器的方式，记录审计日记
 */

@Configuration
public class AccessLogInterceptor implements HandlerInterceptor {
    // 请求开始时间标识
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    // 请求日记实体标识
    private static final String LOGGER_ACCESSLOG = "ACCESSLOG_ENTITY";

    private static final Logger logger = LoggerFactory.getLogger("ACCESS_LOG");


    // 进入 SpringMVC 的 controller 之前开始记录日记实体
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 创建日记实体
        AccessLog accessLog = new AccessLog();

        // 设置IP地址
        accessLog.setIp(AddressIPUtils.getIpAddress(request));

        // 设置请求方法
        accessLog.setHttpMethod(request.getMethod());

        // 设置请求路径
        accessLog.setUrl(request.getRequestURI());

        // 设置请求开始时间
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());

        // 设置请求实体到request内，方便afterCompletion方法调用
        request.setAttribute(LOGGER_ACCESSLOG, accessLog);
        return true;
    }


    // 完成controller后
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 获取本次请求日记实体
        AccessLog accessLog = (AccessLog) request.getAttribute(LOGGER_ACCESSLOG);
        //获取请求错误码，根据需求存入数据库，这里不保存
        int status = response.getStatus();
        accessLog.setHttpStatus(status);

        //设置访问者(这里暂时写死）
        // 因为不同的应用可能将访问者信息放在session里面，有的通过request传递，
        // 总之可以获取到，但获取的方法不同
        accessLog.setUsername("admin");

        //当前时间
        long currentTime = System.currentTimeMillis();

        //请求开始时间
        long sendTime = Long.valueOf(request.getAttribute(LOGGER_SEND_TIME).toString());


        //设置请求时间差
        accessLog.setDuration(Integer.valueOf((currentTime - sendTime)+""));

        accessLog.setCreateTime(new Date());
        //将accessLog对象持久化保存
        logger.info(accessLog.toString());

    }
}
