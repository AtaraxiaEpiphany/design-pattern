package org.example.chainOfResponsibility.impl;

import com.common.util.LogUtil;
import org.example.chainOfResponsibility.Handler;
import org.example.chainOfResponsibility.LeaveRequest;

/**
 * @Title: GroupLeader 组长类
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility.impl
 * @Date 05/08/2023 10:49
 * @Description: TODO Concrete Handler 具体处理者
 */
public class GroupLeader extends Handler {
    public GroupLeader() {
        super(0, NUM_ONE);
    }

    @Override
    protected void handle(LeaveRequest leaveRequest) {
        LogUtil.FG_YELLOW.print("Group leader handling...");
        LogUtil.FG_YELLOW.print("Name ==> %s, reason ==> %s, days ==> %s",
                leaveRequest.getName(), leaveRequest.getReason(), leaveRequest.getDays());

    }
}
