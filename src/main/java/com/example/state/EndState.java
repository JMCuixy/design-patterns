package com.example.state;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/16 09:19
 */
public class EndState implements State {

    private Order order;

    public EndState(Order order) {
        this.order = order;
    }

    @Override
    public void orderCreate() {
        System.out.println("乘客下单，订单新建中...");
        order.setState(order.getNewState());
    }

    @Override
    public void orderCancel() {
        System.out.println("无可取消订单");
    }

    @Override
    public void orderMatch() {
        System.out.println("无可匹配订单");
    }

    @Override
    public void evaluation() {
        System.out.println("无可评价订单");
    }
}
