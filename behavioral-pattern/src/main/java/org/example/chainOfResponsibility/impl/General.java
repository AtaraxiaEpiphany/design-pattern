package org.example.chainOfResponsibility.impl;

import com.common.util.LogUtil;
import org.example.chainOfResponsibility.Handler;
import org.example.chainOfResponsibility.LeaveRequest;

/**
 * @Title: General 总经理
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility.impl
 * @Date 05/08/2023 10:58
 * @Description: TODO Concrete  Handler
 */
public class General extends Handler {

    public General() {
        super(NUM_THREE, NUM_SEVEN);
    }

    @Override
    protected void handle(LeaveRequest leaveRequest) {
        LogUtil.FG_YELLOW.print("General handling...");
        LogUtil.FG_YELLOW.print("Name ==> %s, reason ==> %s, days ==> %s",
                leaveRequest.getName(), leaveRequest.getReason(), leaveRequest.getDays());

    }
}
