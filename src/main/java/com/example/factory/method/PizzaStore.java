package com.example.factory.method;

/**
 * @Description: 抽象工厂
 * @author: cuixiuyin
 * @date: 2018/11/19 09:02
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        System.out.println(pizza.name);
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }

    protected abstract Pizza createPizza(String type);
}
