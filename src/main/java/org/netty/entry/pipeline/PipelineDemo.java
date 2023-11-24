package org.netty.entry.pipeline;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: PipelineDemo
 * @Author Hannibal
 * @Package org.netty.entry.pipeline
 * @Date 23/11/2023 22:01
 * @Description: TODO
 */
@Slf4j
public class PipelineDemo {
    /**
     * 注意inbound handler 与 outbound handler 执行顺序.
     */
    public static void main(String[] args) {
        DefaultEventLoop eventExecutors = new DefaultEventLoop();
        new ServerBootstrap()
                .group(new NioEventLoopGroup(), new NioEventLoopGroup(2))
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
//                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new StringDecoder());
                        /**
                         * Inbound handler
                         * h1 -> h2 -> h3 -> tail
                         */
                        ch.pipeline().addLast("inbound handler one", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.info("Inbound handler one.");
                                super.channelRead(ctx, msg);
                            }
                        });
                        ch.pipeline().addLast("inbound handler two", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.info("Inbound handler two.");
                                super.channelRead(ctx, msg);
                            }
                        });
                        ch.pipeline().addLast("inbound handler three", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.info("Inbound handler three.");
                                super.channelRead(ctx, msg);
                                /**
                                 * 写数据触发Outbound
                                 * channel: 从最后的handler向前找outbound handler
                                 * ctx: 从当前handler向前找outbound handler
                                 */
                                ch.writeAndFlush(ctx.alloc().buffer().writeBytes("Write msg for client to trigger `Outbound`.".getBytes()));
                            }
                        });

                        /**
                         * Outbound handler
                         *
                         */
                        ch.pipeline().addLast("outbound handler four", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                log.info("Outbound handler four.");
                                super.write(ctx, msg, promise);
                            }
                        });
                        ch.pipeline().addLast("outbound handler five", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                log.info("Outbound handler five.");
                                super.write(ctx, msg, promise);
                            }
                        });
                        ch.pipeline().addLast("outbound handler six", new ChannelOutboundHandlerAdapter() {
                            @Override
                            public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                                log.info("Outbound handler six.");
                                super.write(ctx, msg, promise);
                            }
                        });
                    }
                }).bind("localhost", 8080);
    }
}
