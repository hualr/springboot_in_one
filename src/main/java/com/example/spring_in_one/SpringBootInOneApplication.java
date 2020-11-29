package com.example.spring_in_one;

import com.example.spring_in_one.client.NettyClient;
import com.example.spring_in_one.server.NettyServer;
import java.net.InetSocketAddress;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootInOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInOneApplication.class, args);
        //启动服务端
        NettyServer nettyServer = new NettyServer();
        nettyServer.start(new InetSocketAddress("127.0.0.1", 8090));

        //复制该项目 将服务端删除 修改为客户端 同时启动即可 注意重新配置server.port端口保证两个启动程序不在一个port即可

    /*    //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();*/
    }

}
