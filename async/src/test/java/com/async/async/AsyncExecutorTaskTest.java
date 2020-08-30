package com.async.async;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.Future;

import static java.lang.Thread.sleep;
/**
 线程池调用异步方法测试
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AsyncExecutorTaskTest {

    @Autowired
    private AsyncExecutorTask task;

    @Test
    public void testAsyncCallbackTask() throws Exception {
       task.doTaskOneCallback();
       task.doTaskTwoCallback();
       task.doTaskThreeCallback();
       sleep(30 * 1000L);
    }
}