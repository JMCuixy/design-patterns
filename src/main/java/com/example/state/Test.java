package com.example.state;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/16 09:43
 */
public class Test {

    public static void main(String[] args) {
        Order order = new Order();
        //1、新建订单
        order.orderCreate();
        //2、取消订单
        order.orderCancel();
        //3、新建订单
        order.orderCreate();
        //4、司机接单
        order.orderMatch();
        //5、尝试取消订单
        order.orderCancel();
        //6、乘客评价
        order.evaluation();
    }
}
