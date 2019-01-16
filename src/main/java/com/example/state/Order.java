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

    /***
     * @Description 乘客下单，订单创建
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCreate() {
        state.orderCreate();
    }

    /***
     * @Description 乘客取消，订单取消
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCancel() {
        state.orderCancel();
    }

    /***
     * @Description 司机接单，订单匹配
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderMatch() {
        state.orderMatch();
    }

    /***
     * @Description 乘客评价，订单结束
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
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
