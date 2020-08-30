package com.mybatis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author suYan
 * @Date 2020/5/9 20:04
 * 读取 resources中自定义的 .properties 文件
 */

@Component
@Data
@PropertySource(value = "classpath:/song.properties")
@ConfigurationProperties(prefix = "song")
public class ReadSources {
    // 绑定配置文件的属性
    private String name;
    private String singer;
}
