package org.example.factory.pattern.factoryMethod.impl;

import org.example.factory.pattern.factoryMethod.Coffee;
import org.example.factory.pattern.factoryMethod.CoffeeAbstractFactory;

/**
 * @Title: LatteCoffeeFactory 拿铁咖啡具体工厂
 * @Author Hannibal
 * @Package org.example.factory.pattern.factoryMethod.impl
 * @Date 24/07/2023 22:02
 * @Description: 具体工厂
 */
public class LatteCoffeeFactory implements CoffeeAbstractFactory {
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
}
