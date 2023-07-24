package org.example.factory.pattern.configFactory.impl;

import org.example.factory.pattern.configFactory.Coffee;

/**
 * @Title: LatteCoffee 拿铁咖啡
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory.impl
 * @Date 23/07/2023 22:13
 * @Description: TODO
 */
public class LatteCoffee extends Coffee {
    @Override
    public String getName() {
        return "拿铁咖啡";
    }
}
