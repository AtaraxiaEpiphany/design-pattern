package org.example.factory.pattern.abstractFactory;

/**
 * @Title: DessertFactory 甜品工厂
 * @Author Hannibal
 * @Package org.example.factory.pattern.abstractFactory
 * @Date 24/07/2023 22:42
 * @Description: TODO 抽象工厂
 */
public interface DessertFactory {
    /**
     * @return
     */
    Dessert createDessert();

    Coffee createCoffee();
}
