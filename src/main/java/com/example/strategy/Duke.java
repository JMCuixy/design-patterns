package com.example.strategy;

import com.example.strategy.behavior.fly.FlyBehavior;
import com.example.strategy.behavior.quack.Quackbehavior;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/03 21:33
 */
public class Duke {

    /**
     * 策略对象 - 鸭子叫行为
     */
    private Quackbehavior quackbehavior;

    /**
     * 策略对象 - 鸭子飞行行为
     */
    private FlyBehavior flyBehavior;

    /**
     * 利用多态注入具体的策略对象
     */
    public Duke(Quackbehavior quackbehavior, FlyBehavior flyBehavior) {
        this.quackbehavior = quackbehavior;
        this.flyBehavior = flyBehavior;
    }

    public Duke() {

    }

    /**
     * 策略方法
     */
    public void performFly() {
        flyBehavior.fly();
    }

    /**
     * 策略方法
     */
    public void performQuack() {
        quackbehavior.quack();
    }

    // 其他方法
}
