package org.example.builder.impl;

import org.example.builder.Bike;
import org.example.builder.Builder;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: RuYIBikeBuilder 如意自行车建造者
 * @Author Hannibal
 * @Package org.example.builder.impl
 * @Date 26/07/2023 21:23
 * @Description: TODO 具体建造者
 */
public class RuYIBikeBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("如意:碳纤维车架.");
        FG_YELLOW.print("构建车架中..." + bike.getFrame());
    }

    @Override
    public void buildSeat() {
        bike.setSeat("如意:真皮车座.");
        FG_YELLOW.print("构建车座中..." + bike.getSeat());
    }

    @Override
    public Bike buildBike() {
        return bike;
    }
}
