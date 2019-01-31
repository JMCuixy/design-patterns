package com.example.complex.observable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/31 15:09
 */
public class Observable implements Subject {

    private List<Observer> list = new ArrayList<>();
    private Subject subject;

    public Observable(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void register(Observer observer) {
        list.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        int i = list.indexOf(observer);
        if (i >= 0) {
            list.remove(i);
        }
    }

    @Override
    public void notifyObserver() {
        Iterator<Observer> it = list.iterator();
        while (it.hasNext()) {
            Observer observer = it.next();
            observer.update(subject);
        }
    }
}
