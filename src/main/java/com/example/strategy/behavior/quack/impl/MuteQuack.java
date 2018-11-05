package com.example.strategy.behavior.quack.impl;

import com.example.strategy.behavior.quack.Quackbehavior;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:21
 */
public class MuteQuack implements Quackbehavior {

    @Override
    public void quack() {
        System.out.println("不会叫...");
    }
}
