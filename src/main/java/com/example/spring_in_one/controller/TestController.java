package com.example.spring_in_one.controller;

import org.springframework.aop.framework.AopContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 10:13
 * Version: 1.0.0
 */
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
@RestController
@RequestMapping("/demo")
public class TestController {
    @ResponseBody
    @GetMapping("test/{uuid}")
    public String test(@PathVariable("uuid") String uuid) {
        //按照道理这里是会有效果的 但是目前没看到 我也不知道!
        TestController testController = (TestController) AopContext.currentProxy();
        String s = testController.test2("");
        return "OK";
    }


    //ZNN 所有注入的方法 一定不可以是private方法
    public String test2(String s){
        return "Intern";
    }


}