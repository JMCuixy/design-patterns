package com.example.factory_method.absc;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/22 09:40
 */
public class Test {

    public static void main(String[] args) {
        AbstractFactory abstractFactory = new AFactory();
        PizzaStore pizzaStore = new PizzaStore(abstractFactory);
        pizzaStore.prepare();
        AbstractFactory abstractFactory2 = new BFactory();
        PizzaStore pizzaStore2 = new PizzaStore(abstractFactory2);
        pizzaStore2.prepare();
    }
}
