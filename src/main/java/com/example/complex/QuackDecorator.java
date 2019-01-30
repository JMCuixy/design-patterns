package com.example.complex;

/**
 * @Description: 装饰者模式 —— 统计鸭子 quack 的次数
 * @author: cuixiuyin
 * @date: 2019/01/30 16:53
 */
public class QuackDecorator implements Quackable {

    private Quackable quackable;
    private static Integer count = 0;

    public QuackDecorator(Quackable quackable) {
        this.quackable = quackable;
    }

    @Override
    public void quack() {
        quackable.quack();
        count++;
    }

    public static Integer getCount() {
        return count;
    }
}
