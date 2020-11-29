package com.example.spring_in_one.base.controller;

import com.example.spring_in_one.base.utils.MyException;
import com.example.spring_in_one.base.utils.RedisUtil;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/25 20:57
 * Version: 1.0.0
 */
@RestController
@RequestMapping(value="/redis", produces = "application/json; charset=UTF-8")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedisUtil redisUtil;




    @RequestMapping( "/set/{name}")
    public String setUserName(@ PathVariable String name) {
        redisTemplate.opsForValue().set("1", name);
        return "succees";
    }

    @RequestMapping( "/get/{key}")
    public String getUserName(@PathVariable String key) {
        return  Objects.requireNonNull(redisTemplate.opsForValue().get(key)).toString();
    }

    @RequestMapping( "/newset")
    public Boolean newSetName(String name) throws MyException {
        return redisUtil.setString("2",name);
    }

    @RequestMapping( "/delete")
    public Boolean deleteKey(String key) throws MyException {
        return redisUtil.deleteKey(key);
    }


}