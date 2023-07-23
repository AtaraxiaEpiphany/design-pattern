package org.example.singleton;

import org.example.singleton.pattern.EagerSingletonPattern;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.common.util.ConsoleLogUtil.FG_GREEN;
import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: SingletonDemo 测试类
 * @Author Hannibal
 * @Package org.example.singleton
 * @Date 23/07/2023 17:12
 * @Description: TODO
 */
public class SingletonDemo {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(6);

    @Test
    public void testEager() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        EXECUTOR_SERVICE.submit(() -> {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = EagerSingletonPattern.getSingletonWithInitValue();
                FG_GREEN.print("singleton ==> " + singleton);
                latch.countDown();
            }
        });
        latch.await();
        EXECUTOR_SERVICE.submit(() -> {
            for (int i = 0; i < 100; i++) {
                Singleton singleton = EagerSingletonPattern.getSingletonByStaticBlock();
                FG_YELLOW.print("singleton ==> " + singleton);
            }
        });
    }
}
