package com.su.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

// 参数化测试
@SpringBootTest
class ParameterizedTest {

    @org.junit.jupiter.params.ParameterizedTest // 参数化测试
    @ValueSource(ints = {2, 4, 8})
    void numberBeEvenTest(int num) {
        Assertions.assertEquals(0, num % 2);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @ValueSource(strings = {"小幸运", "夜曲", "云烟成雨"})
    void singerTest(String song) {
        System.out.println(song);
    }

    @org.junit.jupiter.params.ParameterizedTest
    @CsvSource({"0, 田馥甄", "1, 周杰伦"})
    void dataFormCsvTest(long id, String name) {
        System.out.printf("id: %d, name: %s", id, name);
    }
}