package com.example.complex.factory;

import com.example.complex.model.adapter.Goose;
import com.example.complex.model.adapter.GooseAdapter;
import com.example.complex.model.Quackable;
import com.example.complex.model.DuckCall;
import com.example.complex.model.MallardDuck;
import com.example.complex.model.RubberDuck;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 17:04
 */
public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }

    @Override
    public Quackable createGooseDuck() {
        return new GooseAdapter(new Goose());
    }
}
