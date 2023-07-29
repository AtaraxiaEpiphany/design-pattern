package org.example.singleton;

import org.example.singleton.pattern.EagerSingletonPattern;
import org.example.singleton.pattern.EnumSingletonPattern;
import org.example.singleton.pattern.LazySingletonPattern;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.common.util.LogUtil.FG_GREEN;
import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: SingletonDemo 测试类
 * @Author Hannibal
 * @Package org.example.singleton
 * @Date 23/07/2023 17:12
 * @Description: TODO
 */
public class SingletonDemo {

    private final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(6);

    /**
     * 饿汉式
     *
     * @throws InterruptedException
     */
    @Test
    public void testEager() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = EagerSingletonPattern.getSingletonWithInitValue();
                FG_GREEN.print("singleton ==> " + singleton);
                latch.countDown();
            });
        }
        latch.await();
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = EagerSingletonPattern.getSingletonByStaticBlock();
                FG_YELLOW.print("singleton ==> " + singleton);
            });
        }
    }

    /**
     * 懒汉式
     *
     * @throws InterruptedException
     */
    @Test
    public void testLazy() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = LazySingletonPattern.getSingleton();
                FG_YELLOW.print("singleton ==> " + singleton);
            });
        }
    }

    /**
     * 双重检查
     */
    @Test
    void testDoubleCheck() {
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = LazySingletonPattern.getSingletonWithDoubleCheck();
                FG_GREEN.print("singleton ==> " + singleton);
            });
        }
    }

    /**
     * 静态内部类
     */
    @Test
    void testStaticInternalClass() {
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = LazySingletonPattern.getSingletonByStaticInternalClass();
                FG_GREEN.print("singleton ==> " + singleton);
            });
        }
    }

    /**
     * 枚举实现单例
     */
    @Test
    void testEnumSingleton() {
        for (int i = 0; i < 100; i++) {
            EXECUTOR_SERVICE.submit(() -> {
                Singleton singleton = EnumSingletonPattern.instance.getSingleton();
                FG_GREEN.print("singleton ==> " + singleton);
            });
        }
    }
}
