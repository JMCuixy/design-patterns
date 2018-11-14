package com.example.decorator;

/**
 * @Description: 具体组件 - 浓缩咖啡
 * @author: cuixiuyin
 * @date: 2018/11/14 08:51
 */
public class Espresso extends Beverage {


    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }

    @Override
    public String size() {
        return "小杯";
    }
}
