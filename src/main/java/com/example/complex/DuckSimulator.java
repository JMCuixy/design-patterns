package com.example.complex;

import com.example.complex.compose.Flock;
import com.example.complex.factory.AbstractDuckFactory;
import com.example.complex.factory.DecoratorDuckFactory;
import com.example.complex.model.Quackable;
import com.example.complex.model.decorator.QuackDecorator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 16:14
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        // 创建工厂
        AbstractDuckFactory duckFactory = new DecoratorDuckFactory();
        duckSimulator.simulate(duckFactory);

    }

    public void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();
        Quackable gooseAdapter = duckFactory.createGooseDuck();

        System.out.println("Duck Simulator: With Composite - Flocks");
        Flock top = new Flock();

        top.add(mallardDuck);
        top.add(duckCall);
        top.add(rubberDuck);
        top.add(gooseAdapter);

        Flock mallardFlock = new Flock();
        Quackable mallardOne = duckFactory.createMallardDuck();
        Quackable mallardTwo = duckFactory.createMallardDuck();
        Quackable mallardThree = duckFactory.createMallardDuck();
        Quackable mallardFour = duckFactory.createMallardDuck();
        mallardFlock.add(mallardOne);
        mallardFlock.add(mallardTwo);
        mallardFlock.add(mallardThree);
        mallardFlock.add(mallardFour);

        top.add(mallardFlock);

        System.out.println("Duck simulator: Whole Flock Simulation");
        simulator(top);

        System.out.println("Duck simulator: Mallard Flock Simulation");
        simulator(mallardFlock);

        System.out.println("quack count:" + QuackDecorator.getCount());
    }

    public void simulator(Quackable quackable) {
        quackable.quack();
    }

}
