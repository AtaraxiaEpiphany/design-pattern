package org.example.factory.pattern.abstractFactory.impl;

import org.example.factory.pattern.abstractFactory.Dessert;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Tiramisu 提拉米苏
 * @Author Hannibal
 * @Package org.example.factory.pattern.abstractFactory.impl
 * @Date 24/07/2023 22:37
 * @Description: 具体产品类
 */
public class Tiramisu extends Dessert {

    @Override
    public void show() {
        FG_YELLOW.print("提拉米苏...");
    }
}
