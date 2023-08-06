package org.example.interpreter;

/**
 * @Title: AbstractExpression
 * @Author Hannibal
 * @Package org.example.interpreter
 * @Date 06/08/2023 15:52
 * @Description: AbstractExpression 抽象表达式
 */
public abstract class AbstractExpression {
    public abstract int interpret(Context context);
}
