package com.example.observer.observer;

import com.example.observer.observable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: 使用 java 内置的观察者模式，实现 Observer 接口来表示观察者
 * @author: cuixiuyin
 * @date: 2018/11/08 18:12
 */
public class PressureObserver implements Observer {

    public PressureObserver(Observable observable) {
        // 订阅主题
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            Float pressure = weatherData.getPressure();
            System.out.println("我是一个压力观察者,我现在的压力是：" + pressure);
        }
    }
}
