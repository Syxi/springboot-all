package com.atomikos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suYan
 * @Date 2020/8/3 18:42
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "primarydb")
public class Primarydb {
    private String uniqueResourceName;
    private String xaDataSourceClassName;
    private String xaProperties;
    private String url;
    private String user;
    private int password;
    private String exclusiveConnectionMode;
    private String minPoolSize;
    private String maxPoolSize;
    private String testQuery;
}
