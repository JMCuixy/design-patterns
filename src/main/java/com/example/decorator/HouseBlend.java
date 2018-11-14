package com.example.decorator;

/**
 * @Description: 具体组件
 * @author: cuixiuyin
 * @date: 2018/11/14 08:53
 */
public class HouseBlend extends Beverage {

    public HouseBlend() {
        description = "HouseBlend";
    }

    @Override
    public double cost() {
        return 0.89;
    }

    @Override
    public String size() {
        return "小杯";
    }
}
