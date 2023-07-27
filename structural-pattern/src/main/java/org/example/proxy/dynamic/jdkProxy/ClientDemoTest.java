package org.example.proxy.dynamic.jdkProxy;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.proxy.dynamic.jdkProxy
 * @Date 27/07/2023 20:56
 * @Description: TODO
 */
public class ClientDemoTest {

    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory();
        SellTickets proxyInstance = factory.getProxy();
        proxyInstance.sell();
    }
}
