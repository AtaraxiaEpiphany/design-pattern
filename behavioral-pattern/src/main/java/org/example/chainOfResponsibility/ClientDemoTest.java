package org.example.chainOfResponsibility;

import org.example.chainOfResponsibility.impl.General;
import org.example.chainOfResponsibility.impl.GroupLeader;
import org.example.chainOfResponsibility.impl.Manager;
import org.junit.jupiter.api.Test;

/**
 * @Title: ClientDemoTest
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility
 * @Date 05/08/2023 11:00
 * @Description: TODO
 */
public class ClientDemoTest {
    @Test
    public void test() {
        LeaveRequest leaveRequest = new LeaveRequest("张三", 7, "调休");
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        General general = new General();
        /**
         * 设置处理链
         */
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(general);

        groupLeader.submit(leaveRequest);
    }
}
