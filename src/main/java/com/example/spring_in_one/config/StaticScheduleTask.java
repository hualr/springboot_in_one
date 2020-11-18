package com.example.spring_in_one.config;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/18 22:49
 * Version: 1.0.0
 */
//1.主要用于标记配置类，兼备Component的效果。
@Configuration
// 2.开启定时任务
@EnableScheduling
public class StaticScheduleTask {
    //3.添加定时任务
    //ZNN 理解cron使用
    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
       // System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    }
}