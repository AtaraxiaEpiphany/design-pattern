package org.example.decorator.impl;

import org.example.decorator.FastFood;

/**
 * @Title: FriedRice 炒饭 Fry.抄/炸
 * @Author Hannibal
 * @Package org.example.decorator.impl
 * @Date 29/07/2023 15:31
 * @Description: Concrete Component 具体组件
 */
public class FriedRice extends FastFood {
    public FriedRice() {
        super(10, "Fast food: fried(fry) rice...");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
