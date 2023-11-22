package org.netty.entry.eventLoop;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @Title: Client
 * @Author Hannibal
 * @Package org.netty.entry.eventLoop
 * @Date 22/11/2023 21:18
 * @Description: TODO
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));//日志
                        ch.pipeline().addLast(new StringEncoder());//对数据加密
                    }
                }).connect("localhost", 8080)
                .sync()
                .channel()
                .writeAndFlush("hello netty");
    }
}
