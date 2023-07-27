package org.example.proxy.dynamic.cglib;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.proxy.dynamic.cglib
 * @Date 27/07/2023 22:04
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        ProxyFactory factory = new ProxyFactory();
        Transaction proxy = factory.getProxy();
        proxy.sell();
    }

    @Test
    void testSpringCglib() {
        SpringProxyFactory proxyFactory  = new SpringProxyFactory();
        Transaction proxy = proxyFactory.getProxy();
        proxy.sell();
    }
}
