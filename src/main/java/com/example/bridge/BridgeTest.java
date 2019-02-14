package com.example.bridge;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/02/14 09:54
 */
public class BridgeTest {

    public static void main(String[] args) {
        Implementor implementorA = new ConcreateImplementorA();
        Implementor implementorB = new ConcreateImplementorB();
        Abstraction abstraction = new RefinedAbstraction();
        // 调用第一个实现
        abstraction.setImplementor(implementorA);
        abstraction.operation();
        // 调用第二个实现
        abstraction.setImplementor(implementorB);
        abstraction.operation();

    }
}
