package org.example.factory.pattern.abstractFactory;

import org.example.factory.pattern.abstractFactory.impl.AmericanoDessertFactory;
import org.junit.jupiter.api.Test;

/**
 * @Title: FactoryDemoTest
 * @Author Hannibal
 * @Package org.example.factory.pattern.abstractFactory
 * @Date 24/07/2023 22:48
 * @Description: 测试类
 */
public class FactoryDemoTest {
    /**
     * 抽象工厂
     */
    @Test
    public void test() {
        /**
         * 生产同一个产品族
         */
        DessertFactory factory = new AmericanoDessertFactory();
        Coffee coffee = factory.createCoffee();
        Dessert dessert = factory.createDessert();
        coffee.addMilk();
        coffee.addSugar();
        dessert.show();
    }
}
