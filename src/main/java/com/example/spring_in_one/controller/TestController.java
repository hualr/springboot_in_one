package com.example.spring_in_one.controller;

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
    @Value("1")
    private String num1;

    @Value("${num.num2}")
    private String num2;


    @RequestMapping("test")
    @ResponseBody
    public String test() {
        System.out.println(num1);
        System.out.println(num2);
        return "OK";
    }


}
