package com.example.factory.method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/19 09:40
 */
public class Test {

    public static void main(String[] args) {
        PizzaStore store = new PizzaFactory();
        store.orderPizza("cheese");
        store.orderPizza("durian");
    }
}
