package org.example.chainOfResponsibility;

import java.util.Objects;

import static com.common.util.LogUtil.FG_GREEN;

/**
 * @Title: Handler 处理者类
 * @Author Hannibal
 * @Package org.example.chainOfResponsibility
 * @Date 05/08/2023 10:41
 * @Description: TODO Handler 抽象处理者
 */
public abstract class Handler {
    protected static final int NUM_ONE = 1;
    protected static final int NUM_THREE = 3;
    protected static final int NUM_SEVEN = 7;

    private int numStart;
    private int numEnd;
    /**
     * Successor 后继处理者.用于将请求传给下一个处理者.
     */
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    protected abstract void handle(LeaveRequest leaveRequest);

    public final void submit(LeaveRequest leaveRequest) {
        this.handle(leaveRequest);
        if (Objects.nonNull(nextHandler) && leaveRequest.getDays() > this.numEnd) {
            /**
             * 传递给Successor
             */
            this.nextHandler.submit(leaveRequest);
        } else {
            FG_GREEN.print(this.getClass().getName() + ":流程结束!");
        }
    }
}
