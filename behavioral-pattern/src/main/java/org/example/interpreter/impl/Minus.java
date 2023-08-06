package org.example.interpreter.impl;

import org.example.interpreter.AbstractExpression;
import org.example.interpreter.Context;

/**
 * @Title: Minus
 * @Author Hannibal
 * @Package org.example.interpreter.impl
 * @Date 06/08/2023 16:08
 * @Description:
 */
public class Minus extends AbstractExpression {

    /**
     * 左表达式.
     */
    private AbstractExpression left;
    /**
     * 右表达式.
     */
    private AbstractExpression right;

    public Minus(AbstractExpression left, AbstractExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret(Context context) {
        return left.interpret(context) - right.interpret(context);
    }

    @Override
    public String toString() {
        return String.format("(%s - %s)", left.toString(), right.toString());
    }
}
