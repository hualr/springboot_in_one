# webSocket学习
## 使用目的
* 避免客户端浏览器不停的从服务端轮询
* 允许服务端主动向客户端推送数据
* 更好的节约了服务器的带宽和资源
## 原理
* 这是一种TCP长连接
* 浏览器和服务器只需要完成一次握手,两者就可以创建持久性的连接,并进行双向的数据传输
## 简单实用说明
* 浏览器到服务器: send当获取WebSocket连接后，浏览器就可以通过 send()
  方法来向服务器发送数据
* 服务器到浏览器: 通过onMessage 事件来接收服务器返回的数据。

