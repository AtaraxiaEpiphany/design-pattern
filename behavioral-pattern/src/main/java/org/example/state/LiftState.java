package org.example.state;

/**
 * @Title: LiftState 电梯
 * @Author Hannibal
 * @Package org.example.state
 * @Date 05/08/2023 11:32
 * @Description: TODO Abstract State
 */
public abstract class LiftState {
    /**
     *
     */
    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void run();

    public abstract void stop();
}
