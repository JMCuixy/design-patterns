package com.example.observer.observable;

import com.example.observer.observer.Observer;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/10 19:57
 */
public interface Subject {
    /**
     * @param observer
     * @return void
     * @Description 观察者订阅
     * @author cuixiuyin
     * @date 2018/11/10 19:59
     */
    void register(Observer observer);

    /**
     * @param observer
     * @return void
     * @Description 观察者取消订阅
     * @author cuixiuyin
     * @date 2018/11/10 19:59
     */
    void remove(Observer observer);

    /**
     * @return void
     * @Description 通知所有观察者
     * @author cuixiuyin
     * @date 2018/11/10 19:59
     */
    void notifyObserver();

}
