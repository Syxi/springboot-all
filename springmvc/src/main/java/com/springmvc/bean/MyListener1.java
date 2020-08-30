package com.springmvc.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author suYan
 * @Date 2020/6/25 18:26
 * 自定义监听器： 实现ApplicationListener接口，OnApplicationEvent方法监听事件
 */

@Component
@Slf4j
public class MyListener1 implements ApplicationListener<MyEvent> {

    public void onApplicationEvent(MyEvent event) {
        log.info(String.format("%s 监听到的事件源: %s", MyListener1.class.getName(), event.getSource()));
    }
}
