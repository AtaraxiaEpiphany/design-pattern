package org.netty.advanced.optimise.option.backlog;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Client
 * @Author Hannibal
 * @Package org.netty.advanced.optimise.option.backlog
 * @Date 02/12/2023 19:08
 * @Description: TODO
 */
@Slf4j
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ChannelFuture future = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new LoggingHandler())
                .connect("localhost", 8080)
                .sync();
        future.channel()
                .closeFuture()
                .sync();
    }
}
