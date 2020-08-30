package com.example.memory;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;

/**
 * @Author suYan
 * @Date 2020/8/5 22:35
 * 任务类QuartzSimpleTask
 */

public class QuartzSimpleTask extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("Quartz简单的定时执行时间" + new Date().toString());
    }
}
