package com.example.database;

import org.quartz.*;


/**
 * @Author suYan
 * @Date 2020/8/7 0:40
 *
 */

public class QuartzUtils {

    /**
     * 创建定时任务，定时任务创建之后默认启动
     * scheduler 调度器
     *  quartzJob 定时任务信息类
     */
    @SuppressWarnings("unchecked")
    public static void createScheduleJob(Scheduler scheduler, QuartzBean quartzBean)
    throws ClassNotFoundException, SchedulerException {
        // 获取定时任务的执行类，必须是类的绝对路径
        // 定时任务类是Job的具体实现， QuartzJobBean是Job的抽象类
        Class<? extends Job> jobClass = (Class<? extends Job>) Class.forName(quartzBean.getJobClass());
        // 构建定时任务信息
        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(quartzBean.getJobName()).build();
        // 构建定时任务执行方式
        CronScheduleBuilder ScheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        // 构建触发器 Trigger
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity(quartzBean.getJobName() )
                .withSchedule(ScheduleBuilder).build();
        scheduler.scheduleJob(jobDetail, cronTrigger);
    }


    /**
     * 根据任务名称暂停定时任务
     * scheduler 调度器
     * jobName 定时任务名称
     */
    public static void pauseScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.pauseJob(jobKey);
    }

    // 根据任务名称恢复暂时任务
    public static void resumeScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.pauseJob(jobKey);
    }

    // 根据任务名称立即运行一次定时任务
    public static void runOnce(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.triggerJob(jobKey);
    }


    /**
     * 更新定时任务类
     * quartzBean 定时任务信息类
     */
    public static void updateScheduleJob(Scheduler scheduler, QuartzBean quartzBean) throws SchedulerException {
        // 获取到对应任务的触发器
        TriggerKey triggerKey = TriggerKey.triggerKey(quartzBean.getJobName());
        // 设定定时任务的执行方式
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(quartzBean.getCronExpression());
        // 重新构造任务触发器 trigger
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
        // 重置对应的 job
        scheduler.rescheduleJob(triggerKey, trigger);
    }


    /**
     * 根据定时任务名称从调度器当中删除定时任务
     */
    public static void deleteScheduleJob(Scheduler scheduler, String jobName) throws SchedulerException {
        JobKey jobKey = JobKey.jobKey(jobName);
        scheduler.deleteJob(jobKey);
    }
}
