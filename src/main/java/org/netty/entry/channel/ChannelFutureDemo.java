package org.netty.entry.channel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: ChannelFutureDemo
 * @Author Hannibal
 * @Package org.netty.entry.channel
 * @Date 22/11/2023 21:32
 * @Description: TODO
 */
@Slf4j
public class ChannelFutureDemo {
    public static void main(String[] args) throws InterruptedException {
        ChannelFuture future = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));//日志
                        ch.pipeline().addLast(new StringEncoder());//对数据加密
                    }
                    /**
                     * 异步非阻塞,真正执行连接的线程是nio线程
                     */
                }).connect("localhost", 8080);

        /**
         * 主线程直接获取channel,空有其表(channel并未建立起连接)
         * 解决办法:
         * 1. 使用sync()让主线程注册同步等待nio线程连接建立
         * 2. 使用addListener()来指定一个回调对象,通过其他线程来调用回调.主线程只负责传递回调
         */
        future.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                Channel channel = future.channel();
                channel.writeAndFlush("Add listener to future.");
            }
        });
        future.sync();
        Channel channel = future.channel();
        channel.writeAndFlush("Sync in main thread.");
    }
}
