package com.su.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
没有使用到Spring Context依赖注入、也没有启动tomcat web容器。整个测试的过程十分的轻量级，速度很快。
 */

@SpringBootTest
@Slf4j
class Mockito1Test {

    // Mock 对象
    private static MockMvc mockMvc;

    // 在所有测试执行之前对Mock对象初始化
    @BeforeAll
    static void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup().build();
    }

    @Test
    void saveStudent() throws Exception {
        String student ="{\n" +
                "   \"id\": 1,\n" +
                "   \"name\": \"苏彦\",\n" +
                "   \"age\": 22\n" +
                "}";
        MvcResult result =  mockMvc.perform(
                MockMvcRequestBuilders
                .request(HttpMethod.POST, "/mockito/students") // 构造一个请求，并执行
                .contentType("application/json")
                .content(student)
        )
                .andExpect(MockMvcResultMatchers.status().is(404))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("苏彦"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(22))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}