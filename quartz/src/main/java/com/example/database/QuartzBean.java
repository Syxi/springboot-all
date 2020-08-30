package com.example.database;

import lombok.Data;

/**
 * @Author suYan
 * @Date 2020/8/7 0:24
 * 定时任务相关实体类
 * 保存定时任务相关信息到数据库中
 */
@Data
public class QuartzBean {
    // 任务id
    private String id;
    // 任务名称
    private String jobName;
    // 任务执行类
    private String jobClass;
    // 任务状态，启动还是暂停
    private Integer status;
    // 任务运行时间表达式
    private String cronExpression;
}
