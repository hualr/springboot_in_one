package com.example.spring_in_one.server;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/29 20:47
 * Version: 1.0.0
 */

import com.example.spring_in_one.server.initializer.ServerChannelInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NettyServer {

    public void start(InetSocketAddress socketAddress) {
        //new 一个主线程组
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        //new 一个工作线程组
        EventLoopGroup workGroup = new NioEventLoopGroup(200);

        /**
         * ChannelOption.SO_BACKLOG 对应tcpIP协议中listene函数中的backlog参数 用于初始化服务端可连接的队列书
         *服务端处理客户端请求是顺序进行的 因此同一事件只能处理一个客户端的连接
         * 当多个客户端来的时候,会将那些暂时处理不了的客户端请求放在一个队列中,这个参数指定了队列大小
         *
         *
         * ChannelOption.SO_REUSRTADDTR 对应socket中对应字段,表示允许重复使用本地治和端口
         * 比如,进程中的80端口已经被某个服务器给用来监听了,此时一个服务器尝试以该端口进行监听就会返回错误,该参数允许服务器公用该端口
         * 常用的场景是,某个进程非正常的退出了,此时端口可能会被占用很长一段时间才可以被其他进程所使用.此时想要恢复连接,就得设置该端口
         *
         * SO_KEEPALIVE 参数对应套接字中的对应字段 用于设置tcp连接,当发现一个tcp连接长时间没有数据通信,就会自动发送一个活动探测的数据报文
         *
         * SO_SNDBUFFE SO_RCVBUF SO_用来操作接收和发送缓冲区的大小 接收缓冲区用来保存网络协议站内收到的数据,直到该引用程序读取成功
         * 发送缓冲区用来保存发送的数据,直到发送成功
         *
         *
         */
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                .localAddress(socketAddress)
                //设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024)
                // 两小时内没有数据的通信时,TCP会自动发送一个活动探测数据报文
                .childOption(ChannelOption.SO_KEEPALIVE, true);
        //绑定端口,开始接收进来的连接
        try {
            ChannelFuture future = bootstrap.bind(socketAddress).sync();
            log.info("服务器启动开始监听端口: {}", socketAddress.getPort());
            /**
             * closeFuture表示开启了一个channel监听器,用来监听channel是否处于关闭状态
             * 当处于关闭状态,子线程才会被关闭(子线程才是真诚进行监听和接收请求的)
             * syncUninterruptibly让主线程同步等待子线程结束
             */
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //关闭主线程组
            bossGroup.shutdownGracefully();
            //关闭工作线程组
            workGroup.shutdownGracefully();
        }
    }
}
