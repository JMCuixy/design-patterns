package com.example.complex;

/**
 * @Description: 鸭鸣器
 * @author: cuixiuyin
 * @date: 2019/01/30 16:11
 */
public class DuckCall implements Quackable {

    @Override
    public void quack() {
        System.out.println("仿呱呱叫");
    }
}
