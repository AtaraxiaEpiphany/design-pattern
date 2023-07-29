package org.example.decorator.impl;

import org.example.decorator.FastFood;

/**
 * @Title: FriedNoodle 炒面
 * @Author Hannibal
 * @Package org.example.decorator.impl
 * @Date 29/07/2023 15:35
 * @Description: TODO Concrete Component 具体组件
 */
public class FriedNoodle extends FastFood {
    public FriedNoodle() {
        super(12, "Fast food: fried noodle...");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
