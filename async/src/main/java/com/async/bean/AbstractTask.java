package com.async.bean;

import java.util.Random;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.sleep;

/**
 * @Author suYan
 * @Date 2020/6/27 19:42
 * 自定义任务栏抽象类
 */

public abstract class AbstractTask {

    private static Random random = new Random();

    public void doTaskOne() throws Exception{
        System.out.println("开始执行任务一");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (start - end) + "秒");
    }

    public void doTaskTwo() throws Exception{
        System.out.println("开始执行任务二");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (start - end) + "秒");
    }

    public void doTaskThree() throws Exception{
        System.out.println("开始执行任务三");
        long start = currentTimeMillis();
        sleep(random.nextInt(10000));
        long end = currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (start - end) + "秒");
    }
}
