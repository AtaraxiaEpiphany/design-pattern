package org.example.factory.pattern.simpleFactory;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Coffee
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory
 * @Date 23/07/2023 22:05
 * @Description: TODO
 */
public abstract class Coffee {
    public abstract String getName();

    public void addSugar() {
        FG_YELLOW.print("%s:加糖...", getName());
    }

    public void addMilk() {
        FG_YELLOW.print("%s:加奶...", getName());
    }
}
