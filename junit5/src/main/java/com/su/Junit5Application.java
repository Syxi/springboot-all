package com.su;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.su.mapper")
public class Junit5Application {

    public static void main(String[] args) {
        SpringApplication.run(Junit5Application.class, args);
    }

}
