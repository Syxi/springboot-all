package com.async.async;

import com.async.sync.SyncTask;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 同步调用
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
class SyncTest {

    @Autowired
    private SyncTask sync;

    // 方法同步调用
    @Test
    public void testSyncTask() throws Exception {
        sync.doTaskOne();
        sync.doTaskTwo();
        sync.doTaskThree();
    }
}