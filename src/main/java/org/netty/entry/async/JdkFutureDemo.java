package org.netty.entry.async;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Title: FutureDemo
 * @Author Hannibal
 * @Package org.netty.entry.async
 * @Date 23/11/2023 21:06
 * @Description: TODO
 */
@Slf4j
public class JdkFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> jdkFuture = executorService.submit(() -> {
            log.info("running in jdk...");
            Thread.sleep(1000);
            return "JDK Future.";
        });
        String ret = jdkFuture.get();
        log.info("Result ==> {}", ret);
    }
}
