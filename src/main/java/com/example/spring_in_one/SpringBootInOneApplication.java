package com.example.spring_in_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
@SpringBootApplication
public class SpringBootInOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInOneApplication.class, args);
    }

}
