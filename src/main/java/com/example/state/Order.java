package com.example.state;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/16 09:22
 */
public class Order {

    private State newState;
    private State cancelState;
    private State runningState;
    private State endState;

    // 默认订单已结束，可开始新一轮叫单
    private State state;

    public Order() {
        newState = new NewState(this);
        cancelState = new CancelState(this);
        runningState = new RunningState(this);
        endState = new EndState(this);
        state = endState;
    }

    void orderCreate() {
        state.orderCreate();
    }

    void orderCancel() {
        state.orderCancel();
    }

    void orderMatch() {
        state.orderMatch();
    }

    void evaluation() {
        state.evaluation();
    }


    public void setState(State state) {
        this.state = state;
    }


    public State getNewState() {
        return newState;
    }

    public State getCancelState() {
        return cancelState;
    }

    public State getRunningState() {
        return runningState;
    }

    public State getEndState() {
        return endState;
    }
}
