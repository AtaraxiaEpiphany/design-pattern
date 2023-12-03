package org.netty.advanced.optimise.option;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: TimeOutDemo
 * @Author Hannibal
 * @Package org.netty.advanced.optimise.option
 * @Date 02/12/2023 17:51
 * @Description: TODO
 */
@Slf4j
public class TimeOutDemo {
    public static void main(String[] args) throws InterruptedException {
        ChannelFuture future = new Bootstrap()
                /**
                 * 调用eventLoop的schedule方法启用定时任务
                 * 通过nio线程通过promise传递结果给main线程
                 */
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 20)
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new LoggingHandler())
                .connect("127.0.0.1", 8080);
        future.sync()
                .channel()
                .closeFuture()
                .sync();
    }
}
