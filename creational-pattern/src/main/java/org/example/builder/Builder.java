package org.example.builder;

/**
 * @Title: Builder 建造者
 * @Author Hannibal
 * @Package org.example.builder
 * @Date 26/07/2023 21:18
 * @Description: TODO 抽象建造者
 */
public abstract class Builder {
    /**
     * 声明自行车,拥有所有组件,但还未组装
     */
    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike buildBike();

}
