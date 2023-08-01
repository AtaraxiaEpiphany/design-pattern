package org.example.flyweight;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: AbstractBox
 * @Author Hannibal
 * @Package org.example.flyweight
 * @Date 01/08/2023 20:27
 * @Description: TODO Flyweight 抽象享元角色
 */
public abstract class AbstractBox {
    /**
     * 获取图形
     *
     * @return
     */
    public abstract String getShape();

    /**
     * Extrinsic state.
     *
     * @param color
     */
    public void display(String color) {
        FG_GREEN.print("方块形状:%s => 颜色 %s", getShape(), color);
    }
}
