package com.example.complex;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 17:04
 */
public class DuckFactory extends AbstractDuckFactory {
    @Override
    public Quackable createMallardDuck() {
        return null;
    }

    @Override
    public Quackable createDuckCall() {
        return null;
    }

    @Override
    public Quackable createRubberDuck() {
        return null;
    }
}
