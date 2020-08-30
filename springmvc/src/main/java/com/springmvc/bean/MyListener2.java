package com.springmvc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @Author suYan
 * @Date 2020/6/25 20:42
 * 自定义监听器：使用@EventListener装饰具体方法实现监听事件
 */

@Component
@Slf4j
public class MyListener2 {

    @EventListener
    public void listener(MyEvent event) {
        log.info(String.format("%s监听到事件源: %s", MyListener2.class.getName(), event.getSource()));
    }
}
