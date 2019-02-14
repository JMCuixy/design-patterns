package com.example.bridge;

/**
 * @Description: 抽象桥接类
 * @author: cuixiuyin
 * @date: 2019/02/14 09:51
 */
public abstract class Abstraction {

    protected Implementor implementor;

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    protected void operation() {
        implementor.operation();
    }
}
