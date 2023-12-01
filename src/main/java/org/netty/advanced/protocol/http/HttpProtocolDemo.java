package org.netty.advanced.protocol.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import static io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH;

/**
 * @Title: HttpProtocolDemo
 * @Author Hannibal
 * @Package org.netty.advanced.protocol.http
 * @Date 26/11/2023 13:11
 * @Description: TODO
 */
@Slf4j
public class HttpProtocolDemo {

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        try {
            ChannelFuture future = new ServerBootstrap()
                    .group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ch.pipeline().addLast(new LoggingHandler());
                            ch.pipeline().addLast(new HttpServerCodec());
//                            ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
//                                @Override
//                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//                                    log.info("msg class ==> {}", msg);
//                                    if (msg instanceof HttpRequest) {
//                                        log.info("Http request...");
//                                    } else if (msg instanceof HttpContent) {
//                                        log.info("Http content...");
//                                    }
//                                }
//                            });
                            /**
                             * 只关注HttpRequest的消息
                             */
                            ch.pipeline().addLast(new SimpleChannelInboundHandler<HttpRequest>() {
                                @Override
                                protected void channelRead0(ChannelHandlerContext ctx, HttpRequest msg) throws Exception {
                                    // 获取请求
                                    log.info("Request URI ==> {}", msg.uri());

                                    // 返回响应
                                    DefaultFullHttpResponse response =
                                            new DefaultFullHttpResponse(msg.protocolVersion(), HttpResponseStatus.OK);

                                    byte[] bytes = "<h1>Hello, netty!</h1>".getBytes();

                                    response.headers().setInt(CONTENT_LENGTH, bytes.length); //L
                                    response.content().writeBytes(bytes); //V

                                    // 写回响应
                                    ctx.writeAndFlush(response);
                                }
                            });

                        }
                    })
                    .bind("localhost", 9000);
            future.sync();
            future.channel()
                    .closeFuture()
                    .sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}
