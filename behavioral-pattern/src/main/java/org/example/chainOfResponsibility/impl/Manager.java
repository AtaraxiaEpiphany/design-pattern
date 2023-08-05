package org.example.chainOfResponsibility.impl;

import com.common.util.LogUtil;
import org.example.chainOfResponsibility.Handler;
import org.example.chainOfResponsibility.LeaveRequest;

/**
 * @Title: Manager 部门经理
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility.impl
 * @Date 05/08/2023 10:56
 * @Description: TODO Concrete Handler
 */
public class Manager extends Handler {

    public Manager() {
        super(NUM_ONE, NUM_THREE);
    }

    @Override
    protected void handle(LeaveRequest leaveRequest) {
        LogUtil.FG_YELLOW.print("Manager handling...");
        LogUtil.FG_YELLOW.print("Name ==> %s, reason ==> %s, days ==> %s",
                leaveRequest.getName(), leaveRequest.getReason(), leaveRequest.getDays());

    }
}
