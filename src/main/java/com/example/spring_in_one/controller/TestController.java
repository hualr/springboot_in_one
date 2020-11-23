package com.example.spring_in_one.controller;

import org.springframework.stereotype.Controller;
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
@RestController
@RequestMapping("/demo")
public class TestController {
    @ResponseBody
    @GetMapping("test/{uuid}")
    public String test(@PathVariable("uuid") String uuid) {
        return "OK";
    }


}