package org.example.builder.extend;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.builder.extend
 * @Date 26/07/2023 21:57
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        /**
         * New builder with no args.
         */
        Phone phone = new Phone.Builder()
                .cpu("Intel")
                .memory("Kingston")
                .build();
    }
}
