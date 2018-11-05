package com.example.strategy.behavior.fly.impl;

import com.example.strategy.behavior.fly.FlyBehavior;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:14
 */
public class FlyNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("不会飞...");
    }
}
