package org.netty.advanced.ping;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

/**
 * @Title: IdleDetect
 * @Author Hannibal
 * @Package org.netty.advanced.ping
 * @Date 01/12/2023 19:43
 * @Description: 空闲检测
 */
@Slf4j
public class IdleDetectServer {
    private static final CountDownLatch countDownLatch = new CountDownLatch(1);

    public static void main(String[] args) {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup(4);
        DefaultEventLoopGroup eventExecutors = new DefaultEventLoopGroup(1);
        ChannelFuture future = null; //同步
        try {
            future = new ServerBootstrap()
                    .group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<NioSocketChannel>() {
                        @Override
                        protected void initChannel(NioSocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            /**
                             * 添加一个空闲状态handler
                             */
                            pipeline.addLast(eventExecutors, new IdleStateHandler(15,
                                    0, 0));
                            /**
                             * 双向handler
                             */
                            pipeline.addLast(eventExecutors, new ChannelDuplexHandler() {
                                //触发特殊事件
                                @Override
                                public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                                    IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
                                    if (IdleState.READER_IDLE.equals(idleStateEvent.state())) {
                                        //Read idle.
                                        log.error("客户端{}超时...", ctx.channel());
                                        ctx.channel().close();
                                    }
                                }
                            });
                            pipeline.addLast(new StringDecoder());
                            pipeline.addLast(new LoggingHandler());
                            pipeline.addLast(new ChannelInboundHandlerAdapter() {
                                @Override
                                public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                    log.info("收到客户端消息:{}==>{}", ctx.channel(), msg);
                                }

                                @Override
                                public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                    log.info("客户端{}断开连接", ctx.channel());
                                }
                            });
                        }
                    }).bind("localhost", 8080);
            future.sync();
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
            eventExecutors.shutdownGracefully();
        }


    }
}
