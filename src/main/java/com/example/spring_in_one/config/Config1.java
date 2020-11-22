package com.example.spring_in_one.config;

import java.util.List;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/22 15:28
 * Version: 1.0.0
 */

/**
 * 这个注解主要是提供自定义属性 在完成pom配置后可以在属性中更加方便的批量注入自己想要的信息
 */
@ConfigurationProperties(prefix = "com.example.config")

/**
 * 等效于一个<bean ></> 只有配置了这个才能被注入
 */
@Component
public class Config1 {
    /**
     * 可以在未配置的情况下提供默认值
     */
    private String name="LiAn";
    private Integer age=16;
    private List<String> friends;

    public String getName() {
        return name;
    }

    /**
     * 必须设置set属性 从而实现属性的注入
     */
    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}