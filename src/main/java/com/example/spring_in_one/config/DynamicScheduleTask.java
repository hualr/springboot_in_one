package com.example.spring_in_one.config;

import java.time.LocalDateTime;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/18 22:54
 * Version: 1.0.0
 */
@Configuration
public class DynamicScheduleTask implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () ->{},
                //2.设置执行周期(Trigger)
                //这个表达式可以直接从数据库中取得 从而实现执行设定数据库中的任务
                triggerContext -> new CronTrigger("0/5 * * * * ?").nextExecutionTime(triggerContext)
        );
    }
}
