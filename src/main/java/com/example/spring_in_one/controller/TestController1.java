package com.example.spring_in_one.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/23 19:34
 * Version: 1.0.0
 */
@RestController
/** 该注解等效于@Controller + @ResponseBody 使用该注解以为这由于返回的是responseBody导致无法返回jsp
 */
@RequestMapping("/home")
public class TestController1 {
    //ZNN 不写则默认返回主页
   //http://localhost:8080/home/
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "hello world!";
    }
    //http://localhost:8080/home/get
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public Map<String, String> get() {
        Map<String, String> map=new HashMap<>();
        map.put("a","1");
        return map;
    }
    // 注意路径
    //http://localhost:8080/home/getMap/1
    @RequestMapping(value="/getMap/{id}", method=RequestMethod.GET)
    public String getMapId(@PathVariable String id) {
        return id;
    }

    //http://localhost:8080/home/getMap2/100/1
    @RequestMapping(value="/getMap2/{id}/{id2}", method=RequestMethod.GET)
    public String getMapId2(@PathVariable String id,@PathVariable String id2) {
        return id;
    }
    //ZNN 注意id参数的位置
    //http://localhost:8080/home/getMap3/1
    @RequestMapping(value="/getMap3/{id}", method=RequestMethod.GET)
    public String getMapId3(@PathVariable("id") String id1) {
        return id1;
    }
}
