package com.springmvc.bean;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @Author suYan
 * @Date 2020/6/24 23:38
 * 自定义ServletRequest的监听器
 *
 *
 * 监听器作用： 在事件发生前、发生后进行一些处理
 * 监听 ServletContext 对象的创建事件、销毁事件和对象中属性发生修改的事件
 * 监听： ServletSession 对象的创建事件、销毁事件和对象中属性发生修改的事件
 * 监听： ServletRequest 对象的创建事件、销毁事件和对象中属性发生修改的事件
 */

@WebListener
@Slf4j
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        log.info("request监听器：销毁");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        log.info("request: 这里可以记录访问次数");
    }
}
