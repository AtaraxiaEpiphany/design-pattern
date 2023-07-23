package org.example.factory;

import org.example.factory.pattern.simpleFactory.CoffeeStore;
import org.junit.jupiter.api.Test;

import static org.example.factory.pattern.enums.CoffeeTypeEnum.*;

/**
 * @Title: FactoryDemo
 * @Author Hannibal
 * @Package org.example.factory
 * @Date 23/07/2023 22:01
 * @Description: TODO
 */
public class FactoryDemo {
    /**
     * 简单工厂测试.
     */
    @Test
    public void simpleFactoryTest() {
        CoffeeStore coffeeStore = new CoffeeStore();
        coffeeStore.orderCoffee(AMERICANO);
        coffeeStore.orderCoffee(LATTE);
    }
}
