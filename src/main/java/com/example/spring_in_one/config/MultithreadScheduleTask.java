package com.example.spring_in_one.config;

import java.time.LocalDateTime;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/18 23:01
 * Version: 1.0.0
 */
@Component
public class MultithreadScheduleTask {

    @Async
    @Scheduled(fixedDelay = 1000)  //间隔1秒
    public void first() throws InterruptedException {
        System.out.println("第一个定时任务开始 : "
                + LocalDateTime.now().toLocalTime()
                + "线程 : "
                + Thread.currentThread().getName());
        Thread.sleep(1000 * 10);
    }

    @Async
    @Scheduled(fixedDelay = 2000)
    public void second() {
        System.out.println("第二个定时任务开始 : "
                + LocalDateTime.now().toLocalTime()
                + "线程 : "
                + Thread.currentThread().getName());
    }
}