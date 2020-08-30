package com.springmvc.bean;

import org.springframework.context.ApplicationEvent;

/**
 * @Author suYan
 * @Date 2020/6/25 18:32
 * 自定义事件：继承自 ApplicationEvent抽象类，然后定义自己的构造器
 */

@SuppressWarnings("serial")
public class MyEvent extends ApplicationEvent {
    // 通过 resource获得事件源
    public MyEvent(Object source) {
        super(source);
    }
}
