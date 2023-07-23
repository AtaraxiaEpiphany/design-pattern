package org.example.singleton.pattern;

import org.example.singleton.Singleton;

import java.util.Objects;

/**
 * @Title: LazySingletonPattern 懒汉式
 * @Author Hannibal
 * @Package org.example.singleton.pattern
 * @Date 23/07/2023 17:29
 * @Description: TODO
 */
public class LazySingletonPattern {
    private static Singleton instance;

    /**
     * 存在线程安全问题
     *
     * @return
     */
    public synchronized static Singleton getSingleton() {
        if (Objects.isNull(instance)) {
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 将Synchronized锁的粒度细化,提升性能.
     * 绝大部分是读操作,读操作是线程安全的.
     *
     * @return
     */
    public static Singleton getSingletonWithDoubleCheck() {
        if (Objects.isNull(instance)) {
            /**
             * 在同一时刻,可能多个线程进入判断条件.
             * 因此需要double check.
             */
            synchronized (LazySingletonPattern.class) {
                if (Objects.nonNull(instance)) {
                    return instance;
                }
                instance = new Singleton();
            }
        }
        return instance;
    }
}
