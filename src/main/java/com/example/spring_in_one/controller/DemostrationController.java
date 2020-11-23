package com.example.spring_in_one.controller;

import com.example.spring_in_one.async.AsyncTest;
import com.example.spring_in_one.async.AsyncWIthReturnValueTest;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
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
    private AsyncTest asyncTest1;
    @Autowired
    private AsyncWIthReturnValueTest asyncTest2;
    @RequestMapping("/async/test1")
    public String get1() throws InterruptedException {
        long timeMillis = System.currentTimeMillis();
        asyncTest1.asyn1();
        asyncTest1.asyn2();
        asyncTest1.asyn3();
        Thread.sleep(1000);
        long escapeTime = System.currentTimeMillis() - timeMillis;
        System.out.println("耗时："+escapeTime);
        return "";
    }
    @RequestMapping("/async/test2")
    public String get2() throws InterruptedException, ExecutionException {
        long timeMillis = System.currentTimeMillis();
        Future<String> async1 = asyncTest2.aysnc1();
        Future<String> async2 = asyncTest2.aysnc2();
        Future<String> async3 = asyncTest2.aysnc3();
        //虽然说当时都没有执行完成 但是由于是异步 因此最后执行完了 因此结束了循环
        while (true) {
            if (async1.isDone()){
                System.out.println("async1执行结果:"+async1.get());
            }
            if (async2.isDone()){
                System.out.println("async2执行结果:"+async2.get());
            }
            if (async3.isDone()){
                System.out.println("async3执行结果:"+async3.get());
            }
            if (async1.isDone() && async2.isDone() && async3.isDone()) {
                break;
            }
            if (async1.isDone() && async2.isDone() && async3.isDone()) {
                break;
            }
            Thread.sleep(1000);
        }
        System.out.println("总共耗时:"+(System.currentTimeMillis()-timeMillis));
        return "SUCCESS";
    }
}
