package org.example.proxy.staticProxy.impl;

import org.example.proxy.staticProxy.SellTickets;

import static com.common.util.LogUtil.FG_YELLOW;

/**
 * @Title: Transaction 火车站售票类
 * @Author Hannibal
 * @Package org.example.proxy.staticProxy.impl
 * @Date 27/07/2023 20:31
 * @Description: TODO 真实主题Real Subject
 */
public class Transaction implements SellTickets {

    @Override
    public void sell() {
        FG_YELLOW.print("火车站卖票...");
    }
}
