package com.su.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.su.bean.Student;
import com.su.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import javax.annotation.Resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

/**
 * @Author suYan
 * @Date 2020/6/17 22:41
 * 真实Servlet环境下的测试
 */

@Slf4j
@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class mockito2Test {

    // Mock 对象
    @Resource
    private MockMvc mockMvc;

    @MockBean
    StudentService studentService;

    @Test
    void saveStudent() throws Exception {
        String student ="{\n" +
                "    \"id\": 1,\n" +
                "    \"name\":\"苏彦\",\n" +
                "    \"age\":18,\n"  +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Student studentObj = objectMapper.readValue(student, Student.class);

        // 打桩
        when(studentService.addStudent(studentObj)).thenReturn("ok");

        MvcResult result =  mockMvc.perform(
                MockMvcRequestBuilders
                        .request(HttpMethod.POST, "/mockito/students") // 构造一个请求，并执行
                        .contentType("application/json")
                        .content(student)
        )
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("苏彦"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(22))
                .andDo(print())
                .andReturn();
        result.getResponse().setCharacterEncoding("UTF-8");
        log.info(result.getResponse().getContentAsString());
    }
}

