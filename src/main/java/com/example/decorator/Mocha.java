package com.example.decorator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/14 09:01
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "+Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

    @Override
    public String size() {
        return beverage.size();
    }
}
