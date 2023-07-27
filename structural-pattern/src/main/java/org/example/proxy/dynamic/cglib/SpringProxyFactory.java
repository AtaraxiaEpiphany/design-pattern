package org.example.proxy.dynamic.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import static com.common.util.ConsoleLogUtil.FG_GREEN;
import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: SpringProxyFactory
 * @Author Hannibal
 * @Package org.example.proxy.dynamic.cglib
 * @Date 27/07/2023 22:24
 * @Description: TODO spring cglib
 */
public class SpringProxyFactory implements MethodInterceptor {
    private Transaction station = new Transaction();

    public Transaction getProxy() {
        return (Transaction) Enhancer.create(station.getClass(), station.getClass().getInterfaces(), this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        FG_GREEN.print("callback: method intercept in spring cglib...");
        FG_YELLOW.print("o ==> " + o.getClass());
        FG_YELLOW.print("method ==> " + method.getClass());
        FG_YELLOW.print("objects ==> " + Arrays.toString(objects));
        FG_YELLOW.print("methodProxy ==> " + methodProxy.getClass());
        return method.invoke(station, objects);
    }
}
