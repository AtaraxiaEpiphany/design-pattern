package org.example.builder.impl;

import org.example.builder.Bike;
import org.example.builder.Builder;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: HelloBikeBuilder 哈喽单车构建者
 * @Author Hannibal
 * @Package org.example.builder.impl
 * @Date 26/07/2023 21:21
 * @Description: TODO 具体构建者
 */
public class HelloBikeBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("哈喽:碳纤维车架.");
        FG_YELLOW.print("构建车架中..." + bike.getFrame());
    }

    @Override
    public void buildSeat() {
        bike.setSeat("哈喽:真皮车座.");
        FG_YELLOW.print("构建车座中..." + bike.getSeat());
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
