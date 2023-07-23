package org.example.factory.pattern.simpleFactory.impl;

import org.example.factory.pattern.simpleFactory.Coffee;

/**
 * @Title: AmericanoCoffee 美式咖啡
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory.impl
 * @Date 23/07/2023 22:15
 * @Description: TODO
 */
public class AmericanoCoffee extends Coffee {

    @Override
    public String getName() {
        return "美式咖啡";
    }
}
