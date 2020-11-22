package com.example.spring_in_one.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/22 21:11
 * Version: 1.0.0
 */
@Configuration
/**
 * configuration 相当于bean
 */
public class Config3 {
    @Value("${com.example.config.name}")
    private String name;

    @Bean
    public String ConfigName(){
        return name;
    }
}
