package com.example.decorator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/14 15:29
 */
public class BigCup extends CondimentDecorator {

    public BigCup(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "+大杯";
    }

    @Override
    public double cost() {
        return beverage.cost() + 1.51;
    }

    @Override
    public String size() {
        return "大杯";
    }
}
