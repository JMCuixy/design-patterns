package com.example.complex;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 16:14
 */
public class DuckSimulator {

    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulate();

    }

    public void simulate() {
        Quackable mallardDuck = new QuackDecorator(new MallardDuck());
        Quackable duckCall = new QuackDecorator(new DuckCall());
        Quackable rubberDuck = new QuackDecorator(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());

        System.out.println("Duck simulator");
        simulator(mallardDuck);
        simulator(duckCall);
        simulator(rubberDuck);
        simulator(gooseAdapter);

        System.out.println("quack count:" + QuackDecorator.getCount());
    }

    public void simulator(Quackable quackable) {
        quackable.quack();
    }

}
