package org.example.state.impl;

import org.example.state.Context;
import org.example.state.LiftState;

/**
 * @Title: CloseState 电梯关闭状态
 * @Author Hannibal
 * @Package org.example.state.impl
 * @Date 05/08/2023 12:01
 * @Description: TODO Concrete State
 */
public class CloseState extends LiftState {

    @Override
    //电梯门关闭，这是关闭状态要实现的动作
    public void close() {
        System.out.println("电梯门关闭...");
    }

    //电梯门关了再打开，逗你玩呢，那这个允许呀
    @Override
    public void open() {
        super.getContext().setLiftState(Context.OPEN_STATE);
        super.getContext().open();
    }


    //电梯门关了就跑，这是再正常不过了
    @Override
    public void run() {
        super.getContext().setLiftState(Context.RUNNING_STATE);
        super.getContext().run();
    }

    //电梯门关着，我就不按楼层
    @Override
    public void stop() {
        super.getContext().setLiftState(Context.STOPPING_STATE);
        super.getContext().stop();
    }
}
