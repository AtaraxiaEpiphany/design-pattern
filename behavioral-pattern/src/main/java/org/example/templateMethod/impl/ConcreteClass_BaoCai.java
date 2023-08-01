package org.example.templateMethod.impl;

import org.example.templateMethod.AbstractClass;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: ConcreteClass_BaoCai 炒白菜
 * @Author Hannibal
 * @Package org.example.templateMethod.impl
 * @Date 01/08/2023 22:01
 * @Description: TODO Concrete Class
 */
public class ConcreteClass_BaoCai extends AbstractClass {
    @Override
    public void pourVegetable() {
        FG_YELLOW.print("爆炒包菜...");
    }

    @Override
    public void pourSauce() {
        FG_YELLOW.print("放入蒜和辣椒...");
    }
}
