package com.example.state;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/16 09:15
 */
public class RunningState implements State {

    private Order order;

    public RunningState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("您有订单在进行中，不可新建订单...");
    }

    @Override
    public void orderCancel() {
        System.out.println("正在行程中的订单，无法取消");
    }

    @Override
    public void orderMatch() {
        System.out.println("您有订单在进行中，不可接其他单");
    }

    @Override
    public void evaluation() {
        System.out.println("乘客评价订单，订单结束...");
        order.setState(order.getEndState());
    }
}
