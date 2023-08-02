package org.example.strategy.impl;

import org.example.strategy.Strategy;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: StrategyOne
 * @Author Hannibal
 * @Package org.example.strategy.impl
 * @Date 02/08/2023 22:01
 * @Description: TODO Concrete Strategy 具体策略
 */
public class StrategyOne implements Strategy {
    @Override
    public void show() {
        FG_GREEN.print("买一送一...");
    }
}
