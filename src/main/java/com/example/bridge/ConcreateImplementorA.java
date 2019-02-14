package com.example.bridge;

/**
 * @Description: 具体实现类A
 * @author: cuixiuyin
 * @date: 2019/02/14 09:49
 */
public class ConcreateImplementorA implements Implementor {

    @Override
    public void operation() {
        System.out.println("this is concreteImplementorA's operation...");
    }
}
