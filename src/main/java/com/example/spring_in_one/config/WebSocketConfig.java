package com.example.spring_in_one.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/16 21:49
 * Version: 1.0.0
 */
@Configuration
public class WebSocketConfig {
    /**
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的对象
     * 没有的话会报404  Error during WebSocket handshake: Unexpected response code: 404
     * 之所以要通过这种方法是因为该注解不在websocketStart里
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
