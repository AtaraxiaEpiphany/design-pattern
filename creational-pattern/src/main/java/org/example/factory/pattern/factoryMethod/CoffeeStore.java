package org.example.factory.pattern.factoryMethod;

/**
 * @Title: CoffeeStore 咖啡店
 * @Author Hannibal
 * @Package org.example.factory.pattern.simpleFactory
 * @Date 23/07/2023 22:16
 * @Description: TODO
 */
public class CoffeeStore {

    /**
     * 工厂对象
     */
    private CoffeeAbstractFactory factory;

    public void setFactory(CoffeeAbstractFactory factory) {
        this.factory = factory;
    }

    public void orderCoffee() {
        Coffee coffee = factory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
    }
}
