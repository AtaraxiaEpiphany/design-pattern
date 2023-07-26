package org.example.builder;

import org.example.builder.impl.HelloBikeBuilder;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.builder
 * @Date 26/07/2023 21:27
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Builder builder = new HelloBikeBuilder();
        Director director = new Director(builder);
        /**
         * 指挥者指挥建造者构建产品
         */
        Bike construct = director.construct();
    }
}
