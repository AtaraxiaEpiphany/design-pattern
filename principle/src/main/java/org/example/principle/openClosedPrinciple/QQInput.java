package org.example.principle.openClosedPrinciple;

/**
 * @Title: SogouInput
 * @Author Hannibal
 * @Package org.example.principle.openClosedPrinciple
 * @Date 23/07/2023 11:04
 * @description: QQ输入法
 */

public class QQInput {
    private AbstractSkin skin;

    /**
     * 聚合关系
     *
     * @param skin
     */
    public void setSkin(AbstractSkin skin) {
        this.skin = skin;
    }

    /**
     * 输入法皮肤展示.
     */
    public void display() {
        skin.display();
    }
}
