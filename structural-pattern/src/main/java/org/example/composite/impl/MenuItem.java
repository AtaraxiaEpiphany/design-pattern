package org.example.composite.impl;

import org.example.composite.MenuComponent;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: MenuItem 菜单项
 * @Author Hannibal
 * @Package org.example.composite.impl
 * @Date 31/07/2023 21:55
 * @Description: Leaf  叶子节点
 */
public class MenuItem extends MenuComponent {

    public MenuItem(String name, int level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        FG_GREEN.print(" ==> %s", name);
    }
}
