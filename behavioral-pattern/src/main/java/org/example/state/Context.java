package org.example.state;

import org.example.state.impl.CloseState;
import org.example.state.impl.OpenState;
import org.example.state.impl.RunningState;
import org.example.state.impl.StoppingState;

/**
 * @Title: Context
 * @Author Hannibal
 * @Package org.example.state
 * @Date 05/08/2023 11:49
 * @Description: Context
 */
public class Context {
    public final static OpenState OPEN_STATE = new OpenState();
    public final static CloseState CLOSE_STATE = new CloseState();
    public final static RunningState RUNNING_STATE = new RunningState();
    public final static StoppingState STOPPING_STATE = new StoppingState();

    private LiftState liftState;

    public LiftState getLiftState() {
        return liftState;
    }

    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        /**
         * 将Context传给状态类.
         */
        this.liftState.setContext(this);
    }

    public void open() {
        this.liftState.open();
    }

    public void close() {
        this.liftState.close();
    }

    public void run() {
        this.liftState.run();
    }

    public void stop() {
        this.liftState.stop();
    }
}
