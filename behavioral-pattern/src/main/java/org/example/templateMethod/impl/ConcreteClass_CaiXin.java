package org.example.templateMethod.impl;

import org.example.templateMethod.AbstractClass;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: ConcreteClass_CaiXin 炒菜心
 * @Author Hannibal
 * @Package org.example.templateMethod.impl
 * @Date 01/08/2023 22:03
 * @Description: TODO Concrete Class
 */
public class ConcreteClass_CaiXin extends AbstractClass {
    @Override
    public void pourVegetable() {
        FG_YELLOW.print("清炒菜心...");
    }

    @Override
    public void pourSauce() {
        FG_YELLOW.print("少盐少辣椒...");
    }
}
