package org.netty.entry.eventLoop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: Server
 * @Author Hannibal
 * @Package org.netty.entry.refine
 * @Date 22/11/2023 19:34
 * @Description: 分工细化
 */
@Slf4j
public class Server {
    public static void main(String[] args) {
        /**
         * ## 细分2
         * Netty中不要阻塞IO线程, 将处理业务的worker线程分工细化,由外部线程处理业务.
         */
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        new ServerBootstrap()
                /**
                 * ## 改进1
                 * Boos: 处理ServerSocketChannel 的 accept,ServerSocketChannel只和一个eventLoop绑定
                 *          因此不需要指定线程数
                 * worker: 负责SocketChannel 的读写
                 */
                .group(new NioEventLoopGroup(), new NioEventLoopGroup(4))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler(LogLevel.DEBUG));
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast("external1", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                //第一次处理
                                log.info("First handle ==>  {}", msg);

                                /**
                                 * 将消息传递给下一个handler
                                 */
                                ctx.fireChannelRead(msg);
                            }
                        }).addLast(eventExecutors, "external2", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                //第二次处理
                                log.info("Second handle ==>  {}", msg);
                            }
                        });
                    }
                }).bind("localhost", 8080);
    }
}
