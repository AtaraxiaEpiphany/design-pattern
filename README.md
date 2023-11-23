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
> 最后可以获取到EventLoopGroup对象,调用`group.shutdownGracefully()`来关闭eventLoop线程.

## Future & Promise

> 在异步处理时，经常用到这两个接口

> 首先要说明 netty 中的 Future 与 jdk 中的 Future 同名，但是是两个接口，netty 的 Future 继承自 jdk 的 Future，而 Promise 又对
> netty Future 进行了扩展

* jdk Future 只能同步等待任务结束（或成功、或失败）才能得到结果
* netty Future 可以同步等待任务结束得到结果，也可以异步方式得到结果，但都是要等任务结束
* netty Promise 不仅有 netty Future 的功能，而且脱离了任务独立存在，只作为两个线程间传递结果的容器

| 功能/名称        | jdk Future      | netty Future                          | Promise |
|--------------|-----------------|---------------------------------------|---------|
| cancel       | 取消任务            | -                                     | -       |
| isCanceled   | 任务是否取消          | -                                     | -       |
| isDone       | 任务是否完成，不能区分成功失败 | -                                     | -       |
| get          | 获取任务结果，阻塞等待     | -                                     | -       |
| getNow       | -               | 获取任务结果，非阻塞，还未产生结果时返回 null             | -       |
| await        | -               | 等待任务结束，如果任务失败，不会抛异常，而是通过 isSuccess 判断 | -       |
| sync         | -               | 等待任务结束，如果任务失败，抛出异常                    | -       |
| isSuccess    | -               | 判断任务是否成功                              | -       |
| cause        | -               | 获取失败信息，非阻塞，如果没有失败，返回null              | -       |
| addLinstener | -               | 添加回调，异步接收结果                           | -       |
| setSuccess   | -               | -                                     | 设置成功结果  |
| setFailure   | -               | -                                     | 设置失败结果  |
