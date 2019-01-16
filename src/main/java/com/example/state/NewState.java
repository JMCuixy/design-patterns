package com.example.state;

/**
 * @Description: New 状态，具体状态类
 * @author: cuixiuyin
 * @date: 2019/01/16 09:01
 */
public class NewState implements State {

    private Order order;

    public NewState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("您有一个订单等待司机接单，不可新建订单");
    }

    @Override
    public void orderCancel() {
        System.out.println("乘客取消订单，订单取消中...");
        order.setState(order.getCancelState());
    }

    @Override
    public void orderMatch() {
        System.out.println("司机接单中...");
        order.setState(order.getRunningState());
    }

    @Override
    public void evaluation() {
        System.out.println("新创建订单，不可评价");
    }
}
