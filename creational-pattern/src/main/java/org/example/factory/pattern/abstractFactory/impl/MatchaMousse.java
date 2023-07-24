package org.example.factory.pattern.abstractFactory.impl;

import org.example.factory.pattern.abstractFactory.Dessert;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: MatchaMousse 抹茶慕斯
 * @Author Hannibal
 * @Package org.example.factory.pattern.abstractFactory.impl
 * @Date 24/07/2023 22:40
 * @Description: 具体产品类
 */
public class MatchaMousse extends Dessert {

    @Override
    public void show() {
        FG_YELLOW.print("抹茶慕斯...");
    }
}
