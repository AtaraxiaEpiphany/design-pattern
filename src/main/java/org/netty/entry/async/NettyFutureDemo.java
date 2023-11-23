package org.netty.entry.async;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoopGroup;
import io.netty.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * @Title: NettyFutureDemo
 * @Author Hannibal
 * @Package org.netty.entry.async
 * @Date 23/11/2023 21:25
 * @Description: TODO
 */
@Slf4j
public class NettyFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoopGroup group = new DefaultEventLoop();

        Future<String> future = group.next().submit(() -> {
            log.info("running in netty...");
            Thread.sleep(1000);
            return "Netty Future.";
        });

        //同步获取结果
        String nettyRet = future.get();
        log.info("result with sync() ==> {}", nettyRet);

        future.addListener(f -> {
            log.info("result with async() ==> {}", f.getNow());
        });

    }
}
