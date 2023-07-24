package org.example.factory.pattern.abstractFactory.impl;

import org.example.factory.pattern.abstractFactory.Coffee;
import org.example.factory.pattern.abstractFactory.Dessert;
import org.example.factory.pattern.abstractFactory.DessertFactory;

/**
 * @Title: AmericanoDessertFactory 美式风味甜品工厂
 * @Author Hannibal
 * @Package org.example.factory.pattern.abstractFactory.impl
 * @Date 24/07/2023 22:45
 * @Description: 具体工厂
 */
public class AmericanoDessertFactory implements DessertFactory {
    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }

    @Override
    public Coffee createCoffee() {
        return new AmericanoCoffee();
    }
}
