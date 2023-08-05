package org.example.state.impl;

import org.example.state.Context;
import org.example.state.LiftState;

/**
 * @Title: StoppingState 电梯停止状态
 * @Author Hannibal
 * @Package org.example.state.impl
 * @Date 05/08/2023 12:02
 * @Description: TODO Concrete State
 */
public class StoppingState extends LiftState {

    //停止状态，开门，那是要的！
    @Override
    public void open() {
        //状态修改
        super.getContext().setLiftState(Context.OPEN_STATE);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.getContext().getLiftState().open();
    }

    @Override
    public void close() {//虽然可以关门，但这个动作不归我执行
        //状态修改
        super.getContext().setLiftState(Context.CLOSE_STATE);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.getContext().getLiftState().close();
    }

    //停止状态再跑起来，正常的很
    @Override
    public void run() {
        //状态修改
        super.getContext().setLiftState(Context.RUNNING_STATE);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.getContext().getLiftState().run();
    }

    //停止状态是怎么发生的呢？当然是停止方法执行了
    @Override
    public void stop() {
        System.out.println("电梯停止了...");
    }
}
