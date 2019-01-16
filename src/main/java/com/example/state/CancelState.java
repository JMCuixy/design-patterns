package com.example.state;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/16 09:06
 */
public class CancelState implements State {

    private Order order;

    public CancelState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("乘客下单，订单新建中...");
        order.setState(order.getNewState());
    }

    @Override
    public void orderCancel() {
        System.out.println("订单已被取消，无可取消订单...");
    }

    @Override
    public void orderMatch() {
        System.out.println("无法接单，该订单已被乘客取消...");
    }

    @Override
    public void evaluation() {
        System.out.println("已取消订单不可评价...");
    }
}
