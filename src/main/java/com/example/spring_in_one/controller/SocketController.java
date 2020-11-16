package com.example.spring_in_one.controller;

import com.example.spring_in_one.core.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/16 21:56
 * Version: 1.0.0
 */
@Controller
public class SocketController {

    @Autowired
    private WebSocketServer webSocketServer;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/webSocket")
    public ModelAndView socket() {
        ModelAndView mav=new ModelAndView("/webSocket");
        //1. 直接找到webSocket.html界面
        return mav;
    }


}
