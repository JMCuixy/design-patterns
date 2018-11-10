package com.example.observer.observable;

import com.example.observer.observer.HumidityObserver;
import com.example.observer.observer.PressureObserver;
import com.example.observer.observer.TemperatureObserver;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Observable;

/**
 * @Description: 使用 java 内置的观察者模式，继承 Observable 类来表示主题
 * @author: cuixiuyin
 * @date: 2018/11/08 09:48
 */
@AllArgsConstructor
@Getter
public class WeatherData extends Observable {
    /**
     * 温度
     */
    private Float temperature;
    /**
     * 湿度
     */
    private Float humidity;
    /**
     * 压力
     */
    private Float pressure;


    /**
     * 假设改变的时候这个方法会被调用
     */
    public void measurementsChanged() {
        setChanged();
        notifyObservers(); // 这种不带参数的方式，由观察者 pull 自己想要的数据。要什么数据由观察者自己决定。
        //notifyObservers(Object arg) // 这种带参数的方式，由主题 push 数据。传什么数据由主题决定。(推荐)
    }

    public static void main(String[] args) {
        // 具体主题实现
        WeatherData weatherData = new WeatherData(24.0F,152F,100F);
        // 观察者订阅
        new HumidityObserver(weatherData);
        new PressureObserver(weatherData);
        new TemperatureObserver(weatherData);
        // 事件发生
        weatherData.measurementsChanged();
    }
}
