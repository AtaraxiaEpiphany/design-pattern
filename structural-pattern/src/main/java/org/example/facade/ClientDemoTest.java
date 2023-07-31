package org.example.facade;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.facade
 * @Date 31/07/2023 21:03
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        SmartFacade smartFacade = new SmartFacade();
        smartFacade.say("open");
        System.out.println("=============");
        smartFacade.say("close");
    }
}
