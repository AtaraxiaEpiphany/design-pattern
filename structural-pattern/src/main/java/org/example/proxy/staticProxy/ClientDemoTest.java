package org.example.proxy.staticProxy;

import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.proxy.staticProxy
 * @Date 27/07/2023 20:36
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        ProxyPoint proxyPoint = new ProxyPoint();
        proxyPoint.sell();
    }
}
