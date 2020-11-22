package com.example.spring_in_one.controller;

import com.example.spring_in_one.config.Config1;
import com.example.spring_in_one.config.Config2;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/22 15:11
 * Version: 1.0.0
 */
@Controller
@RequestMapping("/demo")
public class TestController {
    /**
     * ${key名称}
     * #{表达式}
     */
    @Value("1")
    private String num1;

    @Value("${num.num2}")
    private String num2;

    /**
     * 方法调用
     */
    @Value("#{@config3.configName()}")
    private String config3;

    @Value("#{'${subjects}'.split(',')}")
    private String[] subjects;

    @Value("#{'${subjects}'.split(',')[0]}")
    private String subject1;

    @Value("#{${person}}")
    private Map<String,Integer> person;

    @Value("#{${person}.Mary}")
    private Integer person1Age;
    @Value ("#{systemProperties['user.dir']}")
    private String userDir;

    /**
     * 要想获取值 必须注入的方式 而非new出来对象
     */
    @Autowired
    private Config1 config1;

    @Autowired
    private Config2 config2;


    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(new Config1().getAge());

        System.out.println(config1.getAge());
        System.out.println(config1.getName());
        System.out.println(config1.getFriends());

        System.out.println(config2.getName());
        System.out.println(config2.getAge());

        System.out.println(config3);

        System.out.println(subjects.length);

        System.out.println(subject1);

        System.out.println(person);

        System.out.println(person1Age);

        System.out.println(userDir);
        return "OK";
    }


}
