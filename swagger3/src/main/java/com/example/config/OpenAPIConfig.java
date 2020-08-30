package com.example.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suYan
 * @Date 2020/7/19 21:43
 * 将API分组展示
 * 具体例子在 mybatis 模块
 */

@Configuration
public class OpenAPIConfig {

    @Bean
    public GroupedOpenApi helloApi() {
        return GroupedOpenApi.builder()
                .group("junit5")
                .pathsToMatch("/good/**")
                .build();
    }

    @Bean
    public GroupedOpenApi restApi() {
        return GroupedOpenApi.builder()
                .group("mybatis")
                .pathsToMatch("/students/**")
                .build();
    }
}
