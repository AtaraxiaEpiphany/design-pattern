package org.netty.advanced.optimise.option.backlog;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: BackLogDemo
 * @Author Hannibal
 * @Package org.netty.advanced.optimise.option
 * @Date 02/12/2023 18:58
 * @Description: TODO
 */
@Slf4j
public class BackLogServer {
    public static void main(String[] args) {
        new ServerBootstrap()
                /**
                 * 但服务器处理不了accept()事件时,
                 * 会将客户端信息存放至`全连接队列`中,(类似于线程池队列)
                 * 如果能够处理,会直接触发accept()事件
                 * 通过断点来控制accept()触发
                 */
                .option(ChannelOption.SO_BACKLOG, 2) //设置全连接队列大小
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new LoggingHandler())
                .bind("localhost", 8080);
    }

}
