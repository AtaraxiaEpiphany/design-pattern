package org.netty.entry.async;

import io.netty.channel.DefaultEventLoop;
import io.netty.channel.EventLoop;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.Promise;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

/**
 * @Title: TestPromise
 * @Author Hannibal
 * @Package org.netty.entry.async
 * @Date 23/11/2023 21:06
 * @Description: TODO
 */
@Slf4j
public class PromiseDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        EventLoop eventLoop = new DefaultEventLoop(Executors.defaultThreadFactory());
        Promise<String> promise = new DefaultPromise<>(eventLoop);

        new Thread(() -> {
            log.info("running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //Set Result
            promise.setSuccess("Success in promise");
        }).start();

        String ret = promise.get();
        log.info("result ==> {}", ret);
    }
}
