package com.log4j2.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author suYan
 * @Date 2020/5/4 15:40
 * log4j2
 *   机制：如果一条日志信息的级别大于等于配置文件的级别，就记录
 *  日志级别以及优先级排序: OFF > FATAL > ERROR > WARN > INFO > DEBUG > TRACE > ALL
 */
@Slf4j
@RestController
public class Log4j2Controller {
    @GetMapping("/log")
    public String logLevel() {
        // 指定日记的输出级别，日记记录输出指定级别和更高级别的信息
        log.trace("追踪");
        log.debug("调试");
        log.info("输出重要信息");
        log.warn("警告");
        log.error("错误");
        return "log4js 记录日志";
    }
}
