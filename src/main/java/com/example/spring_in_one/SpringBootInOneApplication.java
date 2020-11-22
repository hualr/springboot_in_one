package com.example.spring_in_one;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class SpringBootInOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInOneApplication.class, args);
    }

}
