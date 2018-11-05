package com.example.strategy;

import com.example.strategy.behavior.fly.impl.FlyNoWay;
import com.example.strategy.behavior.fly.impl.FlyWithWings;
import com.example.strategy.behavior.quack.impl.MuteQuack;
import com.example.strategy.behavior.quack.impl.Quack;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:42
 */
public class Test {

    public static void main(String[] args) {
        DivingDuck divingDuck = new DivingDuck();
        ToyDuck toyDuck = new ToyDuck();
        divingDuck.performQuack();
        divingDuck.performFly();
        System.out.println("---华丽的分割线---");
        toyDuck.performQuack();
        toyDuck.performFly();
    }

}
