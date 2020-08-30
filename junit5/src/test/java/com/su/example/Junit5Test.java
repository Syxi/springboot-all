package com.su.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author suYan
 * @Date 2020/6/12 11:19
 */
@SpringBootTest
@DisplayName("junit5测试类的例子")
public class Junit5Test {
    // 定义在整个测试类开始前执行的操作
    @BeforeAll
    public static void init() {
        System.out.println("在测试类开始前执行的操作");
    }

    @BeforeEach
    public void start() {
        System.out.println("在每一个测试方法开始前执行的操作");
    }

    @Test
    public void testAssertJ() {
        int b = 4;
        // 流式断言写法，代码简洁清爽
        Assertions.assertThat(b).as("数字判断")
                .isNotNull()
                // .isEqualTo(2) 不满足条件，测试失败
                .isEqualTo(4)
                .isLessThan(10)
                .isGreaterThan(3);
    }
}
