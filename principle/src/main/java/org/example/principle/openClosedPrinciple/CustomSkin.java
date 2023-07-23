package org.example.principle.openClosedPrinciple;

import com.common.util.ConsoleLogUtil;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: CustomSkin
 * @Author Hannibal
 * @Package org.example.principle.openClosedPrinciple
 * @Date 23/07/2023 11:03
 * @description: 自定义皮肤
 */

public class CustomSkin extends AbstractSkin {
    @Override
    public void display() {
        FG_YELLOW.print("自定义皮肤...");
    }
}
