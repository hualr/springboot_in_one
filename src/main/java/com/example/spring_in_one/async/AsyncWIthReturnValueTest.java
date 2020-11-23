package com.example.spring_in_one.async;

import java.util.concurrent.Future;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 23:05
 * Version: 1.0.0
 */
@Component
public class AsyncWIthReturnValueTest {

    @Async
    public Future<String> aysnc1() throws InterruptedException {
        long st = System.currentTimeMillis();
        System.out.println("aysnc1 start at:" + st);
        Thread.sleep(7000);
        long end = System.currentTimeMillis();
        System.out.println("aysnc1 cost :" + (end - st));
        return new AsyncResult<String>("aysnc1 is done");
    }

    @Async
    public Future<String> aysnc2() throws InterruptedException {
        long st = System.currentTimeMillis();
        System.out.println("aysnc2 start at:" + st);
        Thread.sleep(7000);
        long end = System.currentTimeMillis();
        System.out.println("aysnc2 cost :" + (end - st));
        return new AsyncResult<String>("aysnc2 is done");
    }

    @Async
    public Future<String> aysnc3() throws InterruptedException {
        Long st = System.currentTimeMillis();
        System.out.println("aysnc3 start at:" + st);
        Thread.sleep(7000);
        long end = System.currentTimeMillis();
        System.out.println("aysnc3 cost :" + (end - st));
        return new AsyncResult<String>("aysnc3 is done");
    }
}