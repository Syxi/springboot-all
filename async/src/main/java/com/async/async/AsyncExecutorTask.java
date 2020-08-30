package com.async.async;

import com.async.bean.AbstractTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @Author suYan
 * @Date 2020/6/27 23:51
 * 异步线程池,并处理异步回调
 */

@Component
public class AsyncExecutorTask extends AbstractTask {

    // 如果异步方法具有返回值，需要使用 Future 来接受回调值
    @Async("taskExecutor")
    public Future<String> doTaskOneCallback() throws Exception {
        super.doTaskOne();
        System.out.println("任务一，当前线程：" + Thread.currentThread().getName());
       return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskTwoCallback() throws Exception {
        super.doTaskTwo();
        System.out.println("任务二，当前线程：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务二完成");
    }

    @Async("taskExecutor")
    public Future<String> doTaskThreeCallback() throws Exception {
        super.doTaskThree();
        System.out.println("任务三，当前线程：" + Thread.currentThread().getName());
        return new AsyncResult<>("任务三完成");
    }
}
