package com.example.spring_in_one.controller;

import com.example.spring_in_one.async.AsyncTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 23:01
 * Version: 1.0.0
 */
@RestController
@RequestMapping("/api")
public class DemostrationController {
    @Autowired
    private AsyncTest asyncTest;
    @RequestMapping("/async/test")
    public String get() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        asyncTest.asyn1();
        asyncTest.asyn2();
        asyncTest.asyn3();
        Thread.sleep(1000);
        long escapeTime = System.currentTimeMillis() - timeMillis;
        System.out.println("耗时："+escapeTime);
        return "";
    }
}