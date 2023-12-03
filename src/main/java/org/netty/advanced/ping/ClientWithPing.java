package org.netty.advanced.ping;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: ClientWithPing
 * @Author Hannibal
 * @Package org.netty.advanced.ping
 * @Date 01/12/2023 20:03
 * @Description: TODO
 */
@Slf4j
public class ClientWithPing {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup group = new NioEventLoopGroup();
        Channel channel = new Bootstrap()
                .group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new StringEncoder());
                        pipeline.addLast(new IdleStateHandler(0, 3, 0));
                        pipeline.addLast(new ChannelDuplexHandler() {
                            @Override
                            public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
                                if (((IdleStateEvent) evt).state().equals(IdleState.WRITER_IDLE)) {
                                    //写空闲,发送心跳包,频率比服务器读空闲频率高.
                                    ctx.writeAndFlush("ping");
                                }
                            }

                            @Override
                            public void channelInactive(ChannelHandlerContext ctx) throws Exception {
                                log.info("服务器{}断开连接", ctx.channel());
                            }
                        });
                    }
                }).connect("localhost", 8080)
                .sync()
                .channel();

        channel.writeAndFlush("ping");
        channel.closeFuture()
                .sync();
        group.shutdownGracefully();
    }
}
