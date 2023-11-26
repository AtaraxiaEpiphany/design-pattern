package org.netty.advanced.protocol.redis;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;


/**
 * @Title: RedisDemo
 * @Author Hannibal
 * @Package org.netty.advanced.redis
 * @Date 26/11/2023 12:43
 * @Description: Redis protocol
 */
@Slf4j
public class RedisDemo {
    private static final byte[] LINE = new byte[]{13, 10};

    /**
     *
     * redis protocol
     *
     *   set key value: *3 $3 set $3 key $4 value
     *   *3 ==> 3 parameter
     *   $3 ==> parameter 's length
     *   set ==> parameter value
     *   ...
     */
    public static void main(String[] args) {
        NioEventLoopGroup worker = new NioEventLoopGroup();
        new Bootstrap()
                .group(worker)
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                ByteBuf auth = ctx.alloc().buffer();
                                auth.writeBytes("*2".getBytes());
                                auth.writeBytes(LINE);
                                auth.writeBytes("$4".getBytes());
                                auth.writeBytes(LINE);
                                auth.writeBytes("auth".getBytes());
                                auth.writeBytes(LINE);
                                auth.writeBytes("$7".getBytes());
                                auth.writeBytes(LINE);
                                auth.writeBytes("9660527".getBytes());
                                auth.writeBytes(LINE);
                                ctx.writeAndFlush(auth);
                                ctx.writeAndFlush(set());
                                super.channelActive(ctx);
                            }

                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                log.info("receive ==> {}", msg);
                                super.channelRead(ctx, msg);
                            }
                        });
                    }
                }).connect("tencent", 16379);
    }

    static ByteBuf set() {
        ByteBuf buffer = ByteBufAllocator.DEFAULT.buffer();
        buffer.writeBytes("*3".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("$3".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("set".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("$5".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("netty".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("$8".getBytes());
        buffer.writeBytes(LINE);
        buffer.writeBytes("protocol".getBytes());
        buffer.writeBytes(LINE);
        return buffer;
    }
}
