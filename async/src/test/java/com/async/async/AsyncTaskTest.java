package com.async.async;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
/**
  异步调用
 */

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AsyncTaskTest {

    @Autowired
    private AsyncTask asyncTask;

    @Test
    void testOne() throws Exception{
        asyncTask.testOne();
    }

    @Test
    void testTwo() throws Exception {
        asyncTask.testTwo();
    }

    @Test
    void testThree() throws Exception {
        asyncTask.testThree();
    }
}