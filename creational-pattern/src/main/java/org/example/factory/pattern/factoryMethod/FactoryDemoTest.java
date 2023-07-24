package org.example.factory.pattern.factoryMethod;

import org.example.factory.pattern.factoryMethod.impl.LatteCoffeeFactory;
import org.junit.jupiter.api.Test;

/**
 * @Title: FactoryDemo
 * @Author Hannibal
 * @Package org.example.factory
 * @Date 23/07/2023 22:01
 * @Description: TODO
 */
public class FactoryDemoTest {
    @Test
    public void testFactoryMethod() {
        CoffeeStore coffeeStore = new CoffeeStore();
        /**
         * 后续可以灵活拓展,不需要修改客户端代码.
         * 符合开闭原则.
         */
        coffeeStore.setFactory(new LatteCoffeeFactory());
        coffeeStore.orderCoffee();
    }
}
