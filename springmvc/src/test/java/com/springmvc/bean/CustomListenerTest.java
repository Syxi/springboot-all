package com.springmvc.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class CustomListenerTest {
    @Resource
    private ApplicationContext applicationContext;

    @Test
    public void testEvent() {
        applicationContext.publishEvent(new MyEvent("测试事件"));
    }

}