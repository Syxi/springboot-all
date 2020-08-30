package com.atomikos.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suYan
 * @Date 2020/8/3 19:05
 */

@Data
@Configuration
@ConfigurationProperties("secondarydb")
public class Secondarydb {
    private String uniqueResourceName;
    private String xaDataSourceClassName;
    private String url;
    private String user;
    private int password;
    private String exclusiveConnectionMode;
    private String minPoolSize;
    private String maxPoolSize;
    private String testQuery;
}
