package org.example.composite;

import org.example.composite.impl.Menu;
import org.example.composite.impl.MenuItem;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.composite
 * @Date 31/07/2023 21:57
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        MenuComponent m1 = new Menu("菜单管理", 2);
        m1.add(new MenuItem("页面访问", 3));
        m1.add(new MenuItem("展开菜单", 3));
        m1.add(new MenuItem("编辑菜单", 3));
        m1.add(new MenuItem("删除菜单", 3));
        m1.add(new MenuItem("新增菜单", 3));
        MenuComponent m2 = new Menu("权限管理", 2);
        m2.add(new MenuItem("页面访问", 3));
        m2.add(new MenuItem("提交保存", 3));
        MenuComponent m3 = new Menu("角色管理", 2);
        m3.add(new MenuItem("页面访问", 3));
        m3.add(new MenuItem("新增角色", 3));
        m3.add(new MenuItem("删除角色", 3));
        MenuComponent component = new Menu("系统管理", 1);
        component.add(m1);
        component.add(m2);
        component.add(m3);

        component.print();
    }
}
