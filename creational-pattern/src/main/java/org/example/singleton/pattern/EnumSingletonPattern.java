package org.example.singleton.pattern;

import org.example.singleton.Singleton;

/**
 * @Title: EnumSingletonPattern 枚举实现单例
 * @Author Hannibal
 * @Package org.example.singleton.pattern
 * @Date 23/07/2023 18:53
 * @Description: 唯一不会被破坏的单例创建模式.
 */
public enum EnumSingletonPattern {
    /**
     * 饿汉式.
     */
    instance(new Singleton());

    EnumSingletonPattern(Singleton singleton) {
        this.singleton = singleton;
    }

    private Singleton singleton;

    public Singleton getSingleton() {
        return singleton;
    }
}
