package org.example.builder;

/**
 * @Title: Director 指挥者
 * @Author Hannibal
 * @Package org.example.builder
 * @Date 26/07/2023 21:25
 * @Description: TODO 指挥者
 */
public class Director {
    /**
     * 声明一个建造者
     */
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 构建产品
     *
     * @return
     */
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.buildBike();
    }

}
