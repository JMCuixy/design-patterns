package com.example.complex.model.adapter;

import com.example.complex.model.Quackable;

/**
 * @Description: 鸭子—鹅 适配器
 * @author: cuixiuyin
 * @date: 2019/01/30 16:49
 */
public class GooseAdapter implements Quackable {

    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }

    @Override
    public void quack() {
        goose.honk();
    }
}
