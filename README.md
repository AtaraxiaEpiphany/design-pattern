## Channel事件

- connect: 客户端连接成功时触发
- accept: 服务器端成功接受连接时触发
- read: 数据可读入时触发，有因为接收能力弱，数据暂不能读入的情况
- write: 数据可写出时触发，有因为发送能力弱，数据暂不能写出的情况

## EventLoop

> EventLoop 本质是一个单线程执行器（同时维护了一个 Selector），里面有 run 方法处理 Channel 上源源不断的 io 事件。

### 分工细化

- group中指定Boos与worker. Boss处理ServerSocketChannel的accept.(
  ServerSocketChannel只和一个eventLoop绑定,因此可以不需要指定线程数)
  Worker: 负责SocketChannel 的读写
- Netty中不要阻塞IO线程, 将处理业务的worker线程分工细化,由外部线程处理业务.

## Channel

### ChannelFeature

> `connect`方法是一个异步方法,真正执行连接的线程是nio线程,因此主线程直接获取channel,channel并未真正建立连接

- 使用Future.sync()来阻塞主线程直到连接成功建立
- 使用Feature.addListener()来指定一个回调对象,通过其他线程来调用回调.主线程只负责传递回调

### CloseFeature

> channel.close()方法也是一个异步方法,直接在close()方法下调用关闭逻辑是错误的.
> 可以获取到closeFuture()后,使用sync()或者addListener()来处理关闭逻辑.
