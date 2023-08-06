package org.example.interpreter.impl;

import org.example.interpreter.AbstractExpression;
import org.example.interpreter.Context;

/**
 * @Title: Variable 变量类
 * @Author Hannibal
 * @Package org.example.interpreter.impl
 * @Date 06/08/2023 16:00
 * @Description: TODO
 */
public class Variable extends AbstractExpression {

    /**
     * Variable name.
     */
    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public int interpret(Context context) {
        return context.getValue(this);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
