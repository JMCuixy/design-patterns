package com.example.decorator;

/**
 * @Description: 抽象组件
 * @author: cuixiuyin
 * @date: 2018/11/14 08:47
 */
public abstract class Beverage {

    String description = "Unknown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
