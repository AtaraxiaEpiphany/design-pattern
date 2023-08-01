package org.example.flyweight;

import org.example.flyweight.impl.IBox;
import org.example.flyweight.impl.LBox;
import org.example.flyweight.impl.OBox;

import java.util.HashMap;
import java.util.Objects;

/**
 * @Title: FlyweightBoxFactory box享元工厂
 * @Author Hannibal
 * @Package org.example.flyweight
 * @Date 01/08/2023 20:33
 * @Description: Flyweight Factory 享元工厂
 */
public class FlyweightBoxFactory {

    /**
     * Flyweight pool  享元池,维护享元对象.
     */
    private HashMap<String, AbstractBox> map;

    private FlyweightBoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private final static class StaticInner {
        private static FlyweightBoxFactory factory = new FlyweightBoxFactory();
    }

    /**
     * Singleton
     *
     * @return
     */
    public static FlyweightBoxFactory getFlyweightFactory() {
        return StaticInner.factory;
    }

    public AbstractBox getBoxByName(String name) {
        return map.get(name);
    }

    /**
     * Double check.
     */
    private static FlyweightBoxFactory factory;

    public static FlyweightBoxFactory getFactoryWithDoubleCheck() {
        if (Objects.isNull(factory)) {
            /**
             * Lock write operation.
             */
            synchronized (FlyweightBoxFactory.class) {
                if (Objects.isNull(factory)) {
                    factory = new FlyweightBoxFactory();
                }
            }
        }
        return factory;
    }
}
