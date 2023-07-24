package org.example.factory.pattern.simpleFactory;

import org.junit.jupiter.api.Test;

import static org.example.factory.enums.CoffeeTypeEnum.AMERICANO;
import static org.example.factory.enums.CoffeeTypeEnum.LATTE;

/**
 * @Title: FactoryDemo
 * @Author Hannibal
 * @Package org.example.factory
 * @Date 23/07/2023 22:01
 * @Description: TODO
 */
public class FactoryDemoTest {
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
