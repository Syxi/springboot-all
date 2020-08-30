package com.async.async;

import com.async.bean.AbstractTask;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @Author suYan
 * @Date 2020/6/27 21:57
 * 异步调用
 */

@Component
public class AsyncTask extends AbstractTask {

    @Async // 将原来的同步方法变为异步方法
    public void testOne() throws Exception{
        super.doTaskOne();
    }

    @Async
    public void testTwo() throws Exception {
        super.doTaskTwo();
    }

    @Async
    public void  testThree() throws Exception {
        super.doTaskThree();
    }
}
