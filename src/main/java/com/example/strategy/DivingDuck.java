package com.example.strategy;

import com.example.strategy.behavior.fly.FlyBehavior;
import com.example.strategy.behavior.fly.impl.FlyWithWings;
import com.example.strategy.behavior.quack.Quackbehavior;
import com.example.strategy.behavior.quack.impl.Quack;
import com.example.strategy.behavior.quack.impl.Squeak;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:34
 */
public class DivingDuck extends Duke {


    public DivingDuck() {
        super(new Quack(), new FlyWithWings());
    }

    public DivingDuck(Quackbehavior quackbehavior, FlyBehavior flyBehavior) {
        super(quackbehavior, flyBehavior);
    }
}
