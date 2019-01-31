package com.example.complex.model;

/**
 * @Description: 绿头鸭
 * @author: cuixiuyin
 * @date: 2019/01/30 16:09
 */
public class MallardDuck implements Quackable {

    @Override
    public void quack() {
        System.out.println("呱呱叫");
    }
}
