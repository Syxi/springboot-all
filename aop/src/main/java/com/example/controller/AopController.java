package com.example.controller;

import com.example.annotation.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author suYan
 * @Date 2020/8/29 19:45
 */

@RestController
public class AopController {

    @Async
    @Log("执行方法一")
    @GetMapping("/one")
    public void methodOne() {}

    @Async
    @Log("执行方法二")
    @GetMapping("/two")
    public void methodTwo() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Async
    @Log("执行方法三")
    @GetMapping("/three")
    public void methodThree(String name, String age) { }
}
