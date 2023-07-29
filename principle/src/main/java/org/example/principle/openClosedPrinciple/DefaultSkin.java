package org.example.principle.openClosedPrinciple;

import static com.common.util.LogUtil.FG_GREEN;
import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: DefaultSkin
 * @Author Hannibal
 * @Package org.example.principle.openClosedPrinciple
 * @Date 23/07/2023 11:02
 * @description: 默认皮肤
 */

public class DefaultSkin extends AbstractSkin {
    @Override
    public void display() {
        FG_GREEN.print("默认皮肤...");
    }
}
