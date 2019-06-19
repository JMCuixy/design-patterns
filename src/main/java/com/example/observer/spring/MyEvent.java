package com.example.observer.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @author : cuixiuyin
 * @date : 2019/6/19
 */
@Component
public class MyEvent extends ApplicationEvent {


    public MyEvent(ApplicationContext source) {
        super(source);
        System.out.println("MyEvent 构造器执行");
    }

    public void echo() {
        System.out.println("模拟业务逻辑执行");
    }
}
