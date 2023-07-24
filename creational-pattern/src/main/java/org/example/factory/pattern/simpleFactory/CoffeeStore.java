package org.example.factory.pattern.simpleFactory;

import org.example.factory.pattern.simpleFactory.enums.CoffeeTypeEnum;

/**
 * @Title: CoffeeStore 咖啡店
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory
 * @Date 23/07/2023 22:16
 * @Description: TODO
 */
public class CoffeeStore {
    public void orderCoffee(CoffeeTypeEnum typeEnum) {
        SimpleCoffeeFactory factory = new SimpleCoffeeFactory();
        Coffee coffee = factory.createCoffee(typeEnum);
        coffee.addMilk();
        coffee.addSugar();
    }
}
