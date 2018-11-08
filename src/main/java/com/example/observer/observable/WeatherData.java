package com.example.observer.observable;

import com.example.observer.observer.HumidityObserver;
import com.example.observer.observer.PressureObserver;
import com.example.observer.observer.TemperatureObserver;

import java.util.Observable;

/**
 * @Description: 使用 java 内置的观察者模式，继承 Observable 类来表示主题
 * @author: cuixiuyin
 * @date: 2018/11/08 09:48
 */
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

    public WeatherData() {

    }

    public WeatherData(Float temperature, Float humidity, Float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
    }

    /**
     * 假设改变的时候这个方法会被调用
     */
    public void measurementsChanged() {
        setChanged();
        notifyObservers(); // 这种不带参数的方式，由观察者 pull 自己想要的数据。要什么数据由观察者自己决定。
        //notifyObservers(Object arg) // 这种带参数的方式，由主题 push 数据。传什么数据由主题决定。
    }


    public Float getTemperature() {
        return temperature;
    }

    public Float getHumidity() {
        return humidity;
    }

    public Float getPressure() {
        return pressure;
    }

    public static void main(String[] args) {
        // 新建主题
        WeatherData weatherData = new WeatherData(24.0F,152F,100F);
        // 新建观察者
        new HumidityObserver(weatherData);
        new PressureObserver(weatherData);
        new TemperatureObserver(weatherData);
        weatherData.measurementsChanged();
    }
}
