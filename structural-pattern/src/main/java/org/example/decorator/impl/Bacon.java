package org.example.decorator.impl;

import org.example.decorator.FastFood;
import org.example.decorator.FastFoodDecorator;

/**
 * @Title: Bacon 培根
 * @Author Hannibal
 * @Package org.example.decorator.impl
 * @Date 29/07/2023 15:49
 * @Description: Concrete Component
 */
public class Bacon extends FastFoodDecorator {
    public Bacon(FastFood fastFood) {
        super(fastFood, 2, "Concrete decorator: bacon....");
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return getFastFood().getDesc() + " bacon...";
    }
}
