package org.example.flyweight;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.common.util.LogUtil.FG_GREEN;
import static com.common.util.LogUtil.FG_RED;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.flyweight
 * @Date 01/08/2023 20:46
 * @Description: TODO
 */
public class ClientDemoTest {
    private ExecutorService EXECUTOR = Executors.newFixedThreadPool(6);


    @Test
    void testFlyweight() {
        FlyweightBoxFactory flyweightFactory = FlyweightBoxFactory.getFlyweightFactory();
        AbstractBox i = flyweightFactory.getBoxByName("I");
        i.display("Blue..");
        AbstractBox l = flyweightFactory.getBoxByName("L");
        l.display("Green...");
        AbstractBox o = flyweightFactory.getBoxByName("O");
        o.display("Yellow...");
        AbstractBox oR = flyweightFactory.getBoxByName("O");
        oR.display("Red...");
        FG_RED.print("OBox with yellow equals OBox with red ==> %s", o == oR);
    }

    @Test
    public void testSingleton() {
        for (int i = 0; i < 1000; i++) {
            EXECUTOR.submit(() -> {
                FlyweightBoxFactory factory = FlyweightBoxFactory.getFactoryWithDoubleCheck();
                FG_GREEN.print("factory ==> " + factory);
            });
        }
    }
}

