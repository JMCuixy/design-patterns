package com.example.bridge;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/02/14 09:50
 */
public class ConcreateImplementorB implements Implementor {

    @Override
    public void operation() {
        System.out.println("this is concreteImplementorB's operation...");
    }
}
