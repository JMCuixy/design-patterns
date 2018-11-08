package com.example.observer.observer;

import com.example.observer.observable.WeatherData;

import java.util.Observable;
import java.util.Observer;

/**
 * @Description: 使用 java 内置的观察者模式，实现 Observer 接口来表示观察者
 * @author: cuixiuyin
 * @date: 2018/11/08 18:12
 */
public class HumidityObserver implements Observer {

    private Observable observable;

    public HumidityObserver(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);// 订阅主题
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            Float humidity = weatherData.getHumidity();
            System.out.println("我是一个湿度观察者,我现在的湿度是：" + humidity);
        }
    }
}
