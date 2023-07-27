package org.example.proxy.dynamic.cglib;

import static com.common.util.ConsoleLogUtil.FG_YELLOW;

/**
 * @Title: Transaction 火车站售票类
 * @Author Hannibal
 * @Package org.example.proxy.staticProxy.impl
 * @Date 27/07/2023 20:31
 * @Description: TODO 真实主题Real Subject
 */
public class Transaction {

    public void sell() {
        FG_YELLOW.print("火车站卖票...");
    }
}
