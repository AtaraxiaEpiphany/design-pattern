package org.example.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.common.util.ConsoleLogUtil.FG_GREEN;
import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: ProxyFactory
 * @Author Hannibal
 * @Package org.example.proxy.dynamic.cglib
 * @Date 27/07/2023 21:57
 * @Description: TODO
 */
public class ProxyFactory implements MethodInterceptor {
    private Transaction station = new Transaction();

    public Transaction getProxy() {
        Enhancer enhancer = new Enhancer();
        /**
         * 设置代理类的父类
         */
        enhancer.setSuperclass(station.getClass());
        enhancer.setCallback(this);
        Transaction proxy = (Transaction) enhancer.create();
        return proxy;
    }

    /**
     * Callback.
     *
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        FG_GREEN.print("callback: method intercept...");
        FG_YELLOW.print("o ==> " + o.getClass());
        FG_YELLOW.print("method ==> " + method.getClass());
        FG_YELLOW.print("objects ==> " + Arrays.toString(objects));
        FG_YELLOW.print("methodProxy ==> " + methodProxy.getClass());
        return method.invoke(station, objects);
    }
}
