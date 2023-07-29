package org.example.decorator;

/**
 * @Title: FastFoodDecorator 快餐装饰器
 * @Author Hannibal
 * @Package org.example.decorator
 * @Date 29/07/2023 15:38
 * @Description: Decorator 抽象装饰器
 */
public abstract class FastFoodDecorator extends FastFood {
    /**
     * 持有一个抽象组件的引用
     */
    private FastFood fastFood;

    public FastFoodDecorator(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFoodDecorator(FastFood fastFood) {
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
