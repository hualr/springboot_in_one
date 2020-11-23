package com.example.spring_in_one.controller;

import com.example.spring_in_one.pojo.Apple;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * 1. 注意请求的写法
     */
    //http://localhost:8080/home/getMap4?id=1
    @RequestMapping(value="/getMap4", method=RequestMethod.GET)
    public String getMapId4(@RequestParam("id") String id1) {
        return id1;
    }

    //http://localhost:8080/home/getMap5 允许默认值
    @RequestMapping(value="/getMap5", method=RequestMethod.GET)
    public String getMapId5(@RequestParam(value = "id",required = false,defaultValue="7") String id1) {
        return id1;
    }

    //http://localhost:8080/home/getMap6

    /**
     * {
     *     "color":"red",
     *     "weight":1
     * }
     */
    @RequestMapping(value="/getMap6", method=RequestMethod.GET)
    public Apple getMapId6(@RequestBody Apple apple) {
        return apple;
    }

    /**
     * http://localhost:8080/home/getMap7?id=7
     {
     "color":"red",
     "weight":1
     }
     */
    @RequestMapping(value="/getMap7", method=RequestMethod.GET)
    public Apple getMapId7(@RequestParam String id,@RequestBody Apple apple) {
        System.out.println(id);
        return apple;
    }
}
