package org.example.command.impl;

import org.example.command.Command;
import org.example.command.Order;
import org.example.command.SeniorChef;

import java.util.Map;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: OrderCommand 订单命令
 * @Author Hannibal
 * @Package org.example.command.impl
 * @Date 04/08/2023 21:43
 * @Description: TODO Concrete Command 具体命令
 */
public class OrderCommand implements Command {
    /**
     * 持有接收者Receiver
     */
    private SeniorChef seniorChef;
    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        FG_GREEN.print("%s 桌的订单...", order.getTableId());
        Map<String, Integer> map = order.getFoodDir();
        /**
         *
         */
        map.forEach((k, v) -> seniorChef.makeFood(k, v));
    }
}
