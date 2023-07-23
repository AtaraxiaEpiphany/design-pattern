package org.example.principle.openClosedPrinciple;

import org.junit.jupiter.api.Test;

/**
 * @Title: DemoTest
 * @Author Hannibal
 * @Package org.example.principle.openClosedPrinciple
 * @Date 23/07/2023 11:10
 * @description: 测试方法
 */

public class QQInputDemo {
    @Test
    public void testOpenClosed() {
        AbstractSkin skin = new DefaultSkin();
        QQInput input = new QQInput();
        input.setSkin(skin);
        skin.display();
    }
}

