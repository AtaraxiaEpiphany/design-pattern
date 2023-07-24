package org.example.factory.pattern.factoryMethod.impl;

import org.example.factory.pattern.factoryMethod.Coffee;
import org.example.factory.pattern.factoryMethod.CoffeeAbstractFactory;

/**
 * @Title: AmericanoCoffeeFactory
 * @Author Hannibal
 * @Package org.example.factory.pattern.factoryMethod.impl
 * @Date 24/07/2023 22:00
 * @Description: 具体工厂角色
 */
public class AmericanoCoffeeFactory implements CoffeeAbstractFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanoCoffee();
    }
}
