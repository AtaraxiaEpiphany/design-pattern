package org.netty.advanced.optimise.option;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.embedded.EmbeddedChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

/**
 * @Title: Options
 * @Author Hannibal
 * @Package org.netty.advanced.optimise
 * @Date 02/12/2023 17:20
 * @Description: TODO
 */
@Slf4j
public class Options {
    @Test
    public void Server() {
        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .option(null, null)  //给ServerSocketChannel配置参数
                .childOption(null, null) //给SocketChannel配置参数
                .channel(NioServerSocketChannel.class)
                .handler(null) //给服务器配置handler
                .childHandler(null);//给SocketChannel配置handler

        EmbeddedChannel embeddedChannel = new EmbeddedChannel();
    }
}
