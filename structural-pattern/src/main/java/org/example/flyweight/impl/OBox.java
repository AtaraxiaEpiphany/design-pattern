package org.example.flyweight.impl;

import org.example.flyweight.AbstractBox;

/**
 * @Title: OBox
 * @Author Hannibal
 * @Package org.example.flyweight.impl
 * @Date 01/08/2023 20:32
 * @Description: TODO Concrete Flweight 具体享元角色
 */
public class OBox extends AbstractBox {
    @Override
    public String getShape() {
        return "O";
    }
}
