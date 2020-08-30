package com.su.example;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 使用AssertJ的流式断言
@SpringBootTest
class AssertJSampleTest {
    // 字符串的判断
    @Test
    public void testString() {
        // 断言 null 字符串
        String str = "suYan";
        Assertions.assertThat(str).as("字符串断言描述").startsWith("su")  // "su "开始字符串
                .endsWith("Yan")  // 结束字符串 "Yan"
                .contains("uY")  // 字符串是否包含 "uY"字符串
                .matches(".y")  // 是否匹配 .y 格式
                .isNotNull()  // 是否不为空
                .isIn("ye", "qu")
                .isIn(Arrays.asList("hello"))
                .isExactlyInstanceOf(String.class)
                .isInstanceOfAny(Integer.class, Float.class)
                .isEqualTo("xi")
                .isSameAs("suYan")
                .hasSize(5);
    }

    // 数字断言
    @Test
    public void testInteger() {
        Integer i = 60;
        Assertions.assertThat(i).as("数字断言")
                .isEqualTo(80)
                .isBetween(30,70)
                .isNotNull()
                .isNotZero()  // 是否0
                .isGreaterThan(50)
                .isLessThan(90)
                .isPositive()  // 是否正数
                .isNegative()  // 是否负数
                .isIn(90)
                .isInstanceOf(Integer.class);
    }

    // 日期断言
    @Test
    public void testDate() {
        Assertions.assertThat(new Date()).as("日期断言描述")
                .isAfter("2022-08-08")
                .isAfterYear(2019)
                .isBetween("2020-03-03", "2020-05-08")
                .isEqualToIgnoringHours(new Date().toString())
                .isExactlyInstanceOf(Date.class)
                .isInTheFuture()
                .isToday();
    }

    // List 断言
    @Test
    public void testList() {
        Integer[] a = {1, 2, 3, 4};
        List<Object> list = Arrays.asList(a);
        Assertions.assertThat(list).as("List判断")
                .startsWith("a")
                .endsWith(4)
                .hasSize(4);
    }

    // Map 判断
    @Test
    public void testMap() {
        Map<String,Object> map = new HashMap<>();
        map.put("a", 22);
        map.put("b", "xi");
        map.put("c" , 3);
        Assertions.assertThat(map).as("Map的判断")
                .hasSize(3)
                .containsKeys("a")
                .containsEntry("b", "xi")
                .containsValue(3);
    }
}