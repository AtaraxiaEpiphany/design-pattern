package org.example.singleton.pattern;

import org.example.singleton.Singleton;

/**
 * @Title: EagerSingletonPattern 饿汉式
 * @Author Hannibal
 * @Package org.example.singleton
 * @Date 23/07/2023 17:06
 * @Description: TODO
 */
public class EagerSingletonPattern {
    /**
     * 静态成员变量
     */
    private static Singleton INSTANCE_WITH_INIT_VALUE = new Singleton();

    /**
     * 静态代码块创建,在类加载时执行.
     */
    private static Singleton INSTANCE_BY_STATIC_BLOCK;

    static {
        INSTANCE_BY_STATIC_BLOCK = new Singleton();
    }

    public static Singleton getSingletonWithInitValue() {
        return INSTANCE_WITH_INIT_VALUE;
    }

    public static Singleton getSingletonByStaticBlock() {
        return INSTANCE_BY_STATIC_BLOCK;
    }

}

