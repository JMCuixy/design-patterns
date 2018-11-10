package com.example.observer.observer;

import com.example.observer.observable.Subject;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/10 20:11
 */
public class OwnObserver implements Observer {


    public OwnObserver(Subject subject) {
        subject.register(this);
    }

    @Override
    public void update(Object obj) {
        if (obj instanceof String) {
            System.out.println(obj);
        }
    }
}
