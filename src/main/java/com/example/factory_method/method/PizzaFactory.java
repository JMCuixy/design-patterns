package com.example.factory_method.method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/19 09:38
 */
public class PizzaFactory extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        switch (type) {
            case "cheese":
                return new CheesePizza();
            case "durian":
                return new DurianPizza();
            default:
                break;
        }
        return null;
    }
}
