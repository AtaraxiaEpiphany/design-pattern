package org.example.state;

import org.example.state.impl.CloseState;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.state
 * @Date 05/08/2023 12:25
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Context context = new Context();
        context.setLiftState(new CloseState());

        context.open();
        /**
         * 电梯门开启,并不会执行run.
         */
        context.run();
        context.close();
        context.stop();
    }
}
