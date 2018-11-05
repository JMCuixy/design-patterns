package com.example.strategy.behavior.fly.impl;

import com.example.strategy.behavior.fly.FlyBehavior;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:12
 */
public class FlyWithWings implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("正在飞翔...");
    }
}
