package org.example.state.impl;

import org.example.state.Context;
import org.example.state.LiftState;

/**
 * @Title: OpenState 电梯开启状态
 * @Author Hannibal
 * @Package org.example.state.impl
 * @Date 05/08/2023 12:00
 * @Description: TODO Concrete State
 */
public class OpenState extends LiftState {
    //开启当然可以关闭了，我就想测试一下电梯门开关功能
    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //状态修改
        super.getContext().setLiftState(Context.CLOSE_STATE);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.getContext().getLiftState().close();
    }

    //电梯门不能开着就跑，这里什么也不做
    @Override
    public void run() {
        //do nothing
    }

    //开门状态已经是停止的了
    @Override
    public void stop() {
        //do nothing
    }
}
