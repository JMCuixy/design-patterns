package com.example.bridge;

/**
 * @Description: 扩充抽象类
 * @author: cuixiuyin
 * @date: 2019/02/14 09:52
 */
public class RefinedAbstraction extends Abstraction {

    @Override
    protected void operation() {
        implementor.operation();
    }

}
