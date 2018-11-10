package com.example.observer.observable;

import com.example.observer.observer.Observer;
import com.example.observer.observer.OwnObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/10 20:02
 */
public class ConcreteSubject implements Subject {
    /**
     * 观察者聚集
     */
    private List<Observer> list;

    private String obj;

    public ConcreteSubject() {
        list = new ArrayList<>();
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
        for (int i = 0; i < list.size(); i++) {
            Observer observer = list.get(i);
            observer.update(obj);
        }
    }

    /***
     * @Description 事件发生时，该方法会被调用
     * @author cuixiuyin
     * @date 2018/11/10 20:14
     *
     * @return void
     */
    public void callUpdate() {
        obj = "我是要通知的数据";
        notifyObserver();
    }

    public static void main(String[] args) {
        // 定义主题
        ConcreteSubject concreteSubject = new ConcreteSubject();
        // 观察者订阅
        new OwnObserver(concreteSubject);

        //事件通知
        concreteSubject.callUpdate();
    }

}
