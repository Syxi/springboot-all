package com.example.memory;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author suYan
 * @Date 2020/8/6 23:10
 * quartz的定时任务，内存持久化
 */

@Configuration
public class QuartzSimpleConfig {

    // 指定具体的定时任务类
    @Bean
    public JobDetail uploadTaskDetail() {
        return JobBuilder.newJob(QuartzSimpleTask.class)
                .withIdentity("QuartzSimpleTask")
                .storeDurably().build();
    }

    @Bean
    public Trigger uploadTaskTrigger() {
        // 这里设定触发器的执行方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("*/5 * * * * ?");
        // 返回任务触发器
        return TriggerBuilder.newTrigger().forJob(uploadTaskDetail())
                .withIdentity("QuartzSimpleTask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
