package com.example.spring_in_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class SpringBootInOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInOneApplication.class, args);
    }

}
