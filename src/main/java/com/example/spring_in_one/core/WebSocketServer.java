package com.example.spring_in_one.core;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.springframework.stereotype.Component;

/**
 * Author: zongqi
 * Function:
 * Creating Time：2020/11/16 21:54
 * Version: 1.0.0
 */
@ServerEndpoint("/webSocket/{sid}")
@Component
public class WebSocketServer {
    /**
     * ONLINE_NUM 用来记录当前在线的连接数
     */
    private static final AtomicInteger ONLINE_NUM = new AtomicInteger();

    /**
     * 用来存放每个客户端对应的webSocketServer对象
     */
    private static final ConcurrentHashMap<String, Session> SESSION_POOLS = new ConcurrentHashMap<>();

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String userName){
        SESSION_POOLS.put(userName, session);
        addOnlineCount();
        System.out.println(userName + "加入webSocket！当前人数为" + ONLINE_NUM);
        try {
            sendMessage(session, "欢迎" + userName + "加入连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "sid") String userName){
        SESSION_POOLS.remove(userName);
        subOnlineCount();
        System.out.println(userName + "断开webSocket连接！当前人数为" + ONLINE_NUM);
    }

    /**
     * 给指定用户发送信息
     * @param userName 用户
     * @param message 信息
     */
    public void sendInfo(String userName, String message){
        Session session = SESSION_POOLS.get(userName);
        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    //发送消息给浏览器
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                System.out.println("发送数据给浏览器====>" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }
    @OnError
    public void onError(Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    //收到客户端信息
    @OnMessage
    public void onMessage(String message){
        message = "浏览器端已收到消息：" + message;
        System.out.println(message);
        for (Session session: SESSION_POOLS.values()) {
            try {
                sendMessage(session, message);
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void addOnlineCount(){
        ONLINE_NUM.incrementAndGet();
    }

    public static void subOnlineCount() {
        ONLINE_NUM.decrementAndGet();
    }
}
