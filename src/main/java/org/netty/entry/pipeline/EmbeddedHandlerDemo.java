package org.netty.entry.pipeline;

import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.channel.embedded.EmbeddedChannel;
import lombok.extern.slf4j.Slf4j;

/**
 * @Title: EmbeddedHandlerDemo
 * @Author Hannibal
 * @Package org.netty.entry.pipeline
 * @Date 24/11/2023 21:19
 * @Description: TODO
 */
@Slf4j
public class EmbeddedHandlerDemo {
    private static ChannelInboundHandlerAdapter h1 = new ChannelInboundHandlerAdapter() {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("handler 1 ==> {}", msg);
            super.channelRead(ctx, msg);
        }
    };
    private static ChannelInboundHandlerAdapter h2 = new ChannelInboundHandlerAdapter() {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("handler 2 ==> {}", msg);
            super.channelRead(ctx, msg);
        }
    };

    private static ChannelOutboundHandlerAdapter h3 = new ChannelOutboundHandlerAdapter() {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("handler 3 ==> {}", msg);
            super.write(ctx, msg, promise);
        }
    };

    private static ChannelOutboundHandlerAdapter h4 = new ChannelOutboundHandlerAdapter() {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("handler 4 ==> {}", msg);
            super.write(ctx, msg, promise);
        }
    };

    public static void main(String[] args) {
        EmbeddedChannel embeddedChannel = new EmbeddedChannel(h1, h2, h3, h4);
        embeddedChannel.writeInbound(ByteBufAllocator
                .DEFAULT
                .buffer()
                .writeBytes("hello".getBytes()));

        System.out.println("###################################");
        embeddedChannel.writeOutbound(ByteBufAllocator
                .DEFAULT
                .buffer()
                .writeBytes("world".getBytes()));

        System.out.println("###################################");
        embeddedChannel.writeInbound("inbound...");
        embeddedChannel.writeOutbound("outbound...");
    }
}
