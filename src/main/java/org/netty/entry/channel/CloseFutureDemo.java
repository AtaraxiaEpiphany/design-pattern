package org.netty.entry.channel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * @Title: CloseFutureDemo
 * @Author Hannibal
 * @Package org.netty.entry.channel
 * @Date 22/11/2023 21:37
 * @Description: TODO
 */
@Slf4j
public class CloseFutureDemo {

    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ChannelFuture future = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new StringEncoder());
                    }
                }).connect("localhost", 8080);

        future.sync();

        Channel channel = future.channel();
        log.warn("{}", channel);

        new Thread(() -> {
            Scanner in = new Scanner(System.in);
            while (true) {
                String input = in.nextLine();
                if ("quit".equals(input)) {
                    channel.close();//close也是异步方法,nio线程来关闭的,因此业务逻辑直接写在下方不合理
                    log.error("close operation under close()..."); // xxx
                    break;
                }
                channel.writeAndFlush(input);
            }
        }).start();

        ChannelFuture closeFuture = channel.closeFuture();
        closeFuture.addListener((ChannelFutureListener) cf -> {
            log.error("close operation in listener()..."); // √√√
        });
        closeFuture.sync();
        log.error("close operation after sync()..."); // √√√
        group.shutdownGracefully();
    }
}
