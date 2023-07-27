package org.example.proxy.dynamic.jdkProxy;

import org.example.proxy.dynamic.jdkProxy.impl.Transaction;

import java.lang.reflect.Proxy;

import static com.common.util.ConsoleLogUtil.FG_GREEN;

/**
 * @Title: ProxyFactory 工厂类
 * @Author Hannibal
 * @Package org.example.proxy.dynamic.jdkProxy
 * @Date 27/07/2023 20:47
 * @Description: TODO 获取代理对象的工厂类
 */
public class ProxyFactory {

    /**
     * 声明一个目标对象,火车站售票对象.
     */
    private Transaction station = new Transaction();

    public SellTickets getProxy() {
        /**
         *
         * @param   loader the class loader to define the proxy class
         * @param   interfaces the list of interfaces for the proxy class
         *          to implement
         * @param   h the invocation handler to dispatch method invocations to
         * @return a proxy instance with the specified invocation handler of a
         *          proxy class that is defined by the specified class loader
         *          and that implements the specified interfaces
         */
        return (SellTickets) Proxy.newProxyInstance(station.getClass().getClassLoader(),
                station.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    FG_GREEN.print("JDK Dynamic Proxy.");
                    FG_GREEN.print("proxy ==> %s", proxy.getClass());
                    FG_GREEN.print("method ==> %s", method.getClass());
                    FG_GREEN.print("args == > %s", args);
                    return method.invoke(station, args);
                });
    }


}
