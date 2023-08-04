package org.example.command;

import org.example.command.impl.OrderCommand;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.command
 * @Date 04/08/2023 21:54
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        Order o1 = new Order();
        o1.setTableId("12");
        o1.setFood("西红柿鸡蛋面", 1);
        o1.setFood("大杯可乐", 2);

        Order o2 = new Order();
        o2.setTableId("22");
        o2.setFood("黄焖鸡米饭", 1);
        o2.setFood("大杯雪碧", 2);

        /**
         * Receiver
         */
        SeniorChef receiver = new SeniorChef();
        Command command1 = new OrderCommand(receiver, o1);
        Command command2 = new OrderCommand(receiver, o2);
        Waiter waiter = new Waiter();
        waiter.setCommand(command1);
        waiter.setCommand(command2);
        /**
         * Invoker
         */
        waiter.orderUp();
    }
}
