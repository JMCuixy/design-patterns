package com.example.decorator;

/**
 * @Description: 抽象装饰者，目的是为了达到类型匹配。
 * @author: cuixiuyin
 * @date: 2018/11/14 08:59
 */
public abstract class CondimentDecorator extends Beverage {

    protected Beverage beverage;

    @Override
    public abstract String getDescription();
}
