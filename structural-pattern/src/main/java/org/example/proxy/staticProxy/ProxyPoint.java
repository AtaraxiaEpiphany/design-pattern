package org.example.proxy.staticProxy;

import org.example.proxy.staticProxy.impl.Transaction;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: ProxyPoint 代售点
 * @Author Hannibal
 * @Package org.example.proxy.staticProxy
 * @Date 27/07/2023 20:33
 * @Description: TODO 代理Proxy
 */
public class ProxyPoint implements SellTickets {
    /**
     * 声明售票对象.
     */
    private SellTickets sellTickets = new Transaction();

    @Override
    public void sell() {
        FG_GREEN.print("代售点收取额外费用...");
        /**
         * 真正的售票对象售票功能.
         */
        sellTickets.sell();
    }
}
