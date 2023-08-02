package org.example.strategy;

/**
 * @Title: Context
 * @Author Hannibal
 * @Package org.example.strategy
 * @Date 02/08/2023 22:05
 * @Description: Context 上下文
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 由Context
     */
    public void saleShow() {
        strategy.show();
    }
}
