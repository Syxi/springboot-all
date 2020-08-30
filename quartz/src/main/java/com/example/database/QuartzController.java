package com.example.database;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import static com.example.database.QuartzUtils.*;


/**
 * @Author suYan
 * @Date 2020/8/7 21:29
 */

@Controller
@RequestMapping("/quartz/job")
public class QuartzController {
    // 注入任务调度
    @Resource
    Scheduler scheduler;

    @PostMapping("/create")
    @ResponseBody
    public String createJob(@RequestBody QuartzBean quartzBean) throws SchedulerException, ClassNotFoundException {
        createScheduleJob(scheduler,quartzBean);
        return "已创建任务";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/pause")
    @ResponseBody
    public String pauseJob(String jobName) throws SchedulerException {
        pauseScheduleJob (scheduler,jobName);
        return "已暂停成功";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/run")
    @ResponseBody
    public String runOnce(String jobName) throws SchedulerException {
        QuartzUtils.runOnce (scheduler,jobName);
        return "运行任务" + jobName + "成功";//这里return不是生产级别代码，测试简单写一下
    }

    @PostMapping("/resume")
    @ResponseBody
    public String resume(String jobName) throws SchedulerException {
        resumeScheduleJob(scheduler,jobName);
        return "恢复定时任务成功：" + jobName;
    }

    @PostMapping("/update")
    @ResponseBody
    public String update(@RequestBody QuartzBean quartzBean) throws SchedulerException {
        updateScheduleJob(scheduler,quartzBean);
        return "更新定时任务调度信息成功";
    }

}
