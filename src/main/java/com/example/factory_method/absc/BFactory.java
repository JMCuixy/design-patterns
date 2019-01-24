package com.example.factory_method.absc;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/22 09:36
 */
public class BFactory implements AbstractFactory {

    @Override
    public Pizza createCheese() {
        System.out.println("B工厂制造的奶酪披萨");
        return new CheesePizza();
    }

    @Override
    public Pizza createDurian() {
        System.out.println("B工厂制造的榴莲披萨");
        return new DurianPizza();
    }
}
