package com.example.strategy.behavior.quack.impl;

import com.example.strategy.behavior.fly.FlyBehavior;
import com.example.strategy.behavior.quack.Quackbehavior;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:14
 */
public class Quack implements Quackbehavior {


    @Override
    public void quack() {
        System.out.println("嘎嘎叫...");

    }
}
