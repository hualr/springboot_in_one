package com.example.spring_in_one.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 22:57
 * Version: 1.0.0
 */
@Component
public class AsyncTest {
    @Async
    public void asyn1() throws InterruptedException {
        long timeMilles = System.currentTimeMillis();
        Thread.sleep(7000);
        long escapeTime = System.currentTimeMillis() - timeMilles;
        System.out.println("asyn1耗时:" + escapeTime);
    }

    @Async
    public void asyn2() throws InterruptedException {
        long timeMilles = System.currentTimeMillis();
        Thread.sleep(7000);
        long escapeTime = System.currentTimeMillis() - timeMilles;
        System.out.println("asyn2耗时:" + escapeTime);
    }

    @Async
    public void asyn3() throws InterruptedException {
        long timeMilles = System.currentTimeMillis();
        Thread.sleep(10000);
        long escapeTime = System.currentTimeMillis() - timeMilles;
        System.out.println("asyn3耗时:" + escapeTime);
    }
}