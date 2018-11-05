package com.example.strategy;

import com.example.strategy.behavior.fly.FlyBehavior;
import com.example.strategy.behavior.fly.impl.FlyNoWay;
import com.example.strategy.behavior.quack.Quackbehavior;
import com.example.strategy.behavior.quack.impl.MuteQuack;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/05 09:41
 */
public class ToyDuck extends Duke {


    public ToyDuck() {
        super(new MuteQuack(), new FlyNoWay());
    }

    public ToyDuck(Quackbehavior quackbehavior, FlyBehavior flyBehavior) {
        super(quackbehavior, flyBehavior);
    }
}
