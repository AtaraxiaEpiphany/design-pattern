package org.example.composite;

/**
 * @Title: MenuComponent 菜单Component
 * @Author Hannibal
 * @Package org.example.composite
 * @Date 31/07/2023 21:43
 * @Description: Component 抽象构建类,根节点
 */
public abstract class MenuComponent {
    /**
     * 定义共有的state and action.
     */

    protected String name;
    /**
     * 层级
     */
    protected int level;

    /**
     * 添加子菜单
     *
     * @param menuComponent
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 移除子菜单
     *
     * @param menuComponent
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }

    public abstract void print();

}
