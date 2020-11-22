package com.example.spring_in_one.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/22 20:03
 * Version: 1.0.0
 */
@PropertySource("classpath:custom.properties")
@ConfigurationProperties(prefix = "com.example.config2")
@Component
@Data
public class Config2 {
    private String name="LiPI";
    private int age=22;
}
