package com.example.complex.compose;

import com.example.complex.model.Quackable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/31 09:12
 */
public class Flock implements Quackable {

    List<Quackable> quackables = new ArrayList<>();

    public void add(Quackable quackable) {
        quackables.add(quackable);
    }

    @Override
    public void quack() {
        Iterator<Quackable> it = quackables.iterator();
        while (it.hasNext()) {
            it.next().quack();
        }

    }
}
