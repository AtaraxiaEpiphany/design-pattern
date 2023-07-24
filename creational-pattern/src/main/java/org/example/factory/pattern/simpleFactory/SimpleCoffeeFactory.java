package org.example.factory.pattern.simpleFactory;

import org.example.factory.enums.CoffeeTypeEnum;
import org.example.factory.pattern.simpleFactory.impl.AmericanoCoffee;
import org.example.factory.pattern.simpleFactory.impl.LatteCoffee;

import static org.example.factory.enums.CoffeeTypeEnum.AMERICANO;
import static org.example.factory.enums.CoffeeTypeEnum.LATTE;

/**
 * @Title: SimpleCoffeeFactory 简单工厂
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory
 * @Date 23/07/2023 22:04
 * @Description: TODO
 */
public class SimpleCoffeeFactory {
    public Coffee createCoffee(CoffeeTypeEnum typeEnum) {
        Coffee coffee = null;
        if (AMERICANO.equals(typeEnum)) {
            coffee = new AmericanoCoffee();
        } else if (LATTE.equals(typeEnum)) {
            coffee = new LatteCoffee();
        } else {
            throw new RuntimeException("暂无此类咖啡!");
        }
        return coffee;
    }
}
