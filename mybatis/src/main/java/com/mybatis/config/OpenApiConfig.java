package com.mybatis.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suYan
 * @Date 2020/7/19 23:34
 * Swagger3将Api分组展示
 *
 * 访问：http://localhost:8080/swagger-ui/index.html
 */

@Configuration
public class OpenApiConfig {
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
