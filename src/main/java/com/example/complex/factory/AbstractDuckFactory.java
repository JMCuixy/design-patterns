package com.example.complex.factory;

import com.example.complex.model.Quackable;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 17:01
 */
public abstract class AbstractDuckFactory {

    public abstract Quackable createMallardDuck();

    public abstract Quackable createDuckCall();

    public abstract Quackable createRubberDuck();

    public abstract Quackable createGooseDuck();
}
