package com.example.complex.factory;

import com.example.complex.model.adapter.Goose;
import com.example.complex.model.adapter.GooseAdapter;
import com.example.complex.model.decorator.QuackDecorator;
import com.example.complex.model.Quackable;
import com.example.complex.model.DuckCall;
import com.example.complex.model.MallardDuck;
import com.example.complex.model.RubberDuck;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/31 08:59
 */
public class DecoratorDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackDecorator(new MallardDuck());
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackDecorator(new DuckCall());
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackDecorator(new RubberDuck());
    }

    @Override
    public Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
