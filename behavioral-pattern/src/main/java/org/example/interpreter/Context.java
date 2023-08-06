package org.example.interpreter;

import org.example.interpreter.impl.Variable;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: Context
 * @Author Hannibal
 * @Package org.example.interpreter
 * @Date 06/08/2023 15:59
 * @Description: Context 上下文
 */
public class Context {
    /**
     * 定义Map 存储变量的key value.
     */
    private Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable variable, Integer value) {
        map.put(variable, value);
    }

    public int getValue(Variable variable) {
        return map.get(variable);
    }
}
