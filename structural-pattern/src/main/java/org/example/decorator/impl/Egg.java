package org.example.decorator.impl;

import org.example.decorator.FastFood;
import org.example.decorator.FastFoodDecorator;

/**
 * @Title: Egg 鸡蛋
 * @Author Hannibal
 * @Package org.example.decorator.impl
 * @Date 29/07/2023 15:42
 * @Description: TODO Concrete Component 具体装饰器
 */
public class Egg extends FastFoodDecorator {

    public Egg(FastFood fastFood) {
        super(fastFood, 1, "Concrete decorator: egg....");
    }

    @Override
    public float cost() {
        /**
         * 计算价格.
         */
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc() + " egg...";
    }
}
