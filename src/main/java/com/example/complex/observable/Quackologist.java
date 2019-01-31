package com.example.complex.observable;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/31 15:30
 */
public class Quackologist implements Observer {


    @Override
    public void update(Subject subject) {
        System.out.println("Quackologist: " + subject + "just quacked.");
    }
}
