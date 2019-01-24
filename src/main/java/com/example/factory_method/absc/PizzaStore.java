package com.example.factory_method.absc;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/22 09:39
 */
public class PizzaStore {

    private AbstractFactory abstractFactory;

    public PizzaStore(AbstractFactory abstractFactory) {
        this.abstractFactory = abstractFactory;
    }

    public void prepare() {
        this.abstractFactory.createCheese();
        this.abstractFactory.createDurian();
    }
}
