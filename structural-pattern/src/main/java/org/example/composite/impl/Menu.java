package org.example.composite.impl;

import org.example.composite.MenuComponent;

import java.util.ArrayList;
import java.util.List;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Menu 菜单类
 * @Author Hannibal
 * @Package org.example.composite.impl
 * @Date 31/07/2023 21:49
 * @Description:  Composite 树节点
 */
public class Menu extends MenuComponent {
    List<MenuComponent> menuComponentList = new ArrayList<>();

    public Menu(String name, int level) {
        super.name = name;
        super.level = level;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return menuComponentList.get(index);
    }

    @Override
    public void print() {
        for (int i = 0; i < level; i++) {
            System.out.print("--");
        }
        FG_GREEN.print(" ==> %s", name);
        menuComponentList.forEach(m -> {
            m.print();
        });
    }
}
