package org.example.factory.pattern.configFactory;

import org.junit.jupiter.api.Test;

/**
 * @Title: FactoryDemoTest
 * @Author Hannibal
 * @Package org.example.factory.pattern.configFactory
 * @Date 24/07/2023 23:16
 * @Description: TODO
 */
public class FactoryDemoTest {
    @Test
    public void test() {
        Coffee americano = CoffeeFactory.createCoffee("americano");
        americano.addMilk();
        americano.addSugar();
        Coffee latte = CoffeeFactory.createCoffee("latte");
        latte.addMilk();
        latte.addSugar();
    }
}
