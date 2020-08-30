package com.su.example;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

// junit5框架的常用注解
@DisplayName("我的第一个测试用例")  // @DisplayName为测试类或方法展示名称
@SpringBootTest
class MyFirstTest {

    // 表示在每个测试类运行前，都执行一个指定的方法
    @BeforeAll
    public static void classBeforeAll() {
        System.out.println("清理数据");
    }

    // 表示在每个测试类完成后，都运行一个指定的方法
    @AfterAll
    public static void classAfterAll() {
        System.out.println("所有单元测试完成");
    }

    // 在每个测试方法运行之前，都运行一个指定的方法
    @BeforeEach
    public void eachBefore() {
        System.out.println("当前测试开始");
    }

    // 在每个测试方法运行后，都运行一个指定的方法
    @AfterEach
    public void eachAfter() {
        System.out.println("当前测试完成");
    }

    @DisplayName("第一个测试")
    @Test
    public void Test0() {
        System.out.println("开始我的第一个测试");
    }

    @DisplayName("第二个测试")
    @Test
    public void testDisplayName() {
        System.out.println("开始我的第二个测试");
    }

    @DisplayName("我的第三个测试")
    @Disabled  //  注明一个测试类或测试方法不再运行
    @Test
    public void TestDisabled() {
        System.out.println("开始我的第三个测试");
    }

    @DisplayName("自定义名称重复测试")
    // 重复性测试
    @RepeatedTest(value = 3, name = "{displayName} 第 {currentRepetition} 次")
    public void testRepeat() {
        System.out.println("执行测试");
    }

}