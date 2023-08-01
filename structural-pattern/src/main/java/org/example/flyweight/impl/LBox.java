package org.example.flyweight.impl;

import org.example.flyweight.AbstractBox;

/**
 * @Title: LBox
 * @Author Hannibal
 * @Package org.example.flyweight.impl
 * @Date 01/08/2023 20:31
 * @Description: TODO Concrete Flyweight 具体享元角色
 */
public class LBox extends AbstractBox {
    @Override
    public String getShape() {
        return "L";
    }
}
