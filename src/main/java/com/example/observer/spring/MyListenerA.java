package com.example.observer.spring;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author : cuixiuyin
 * @date : 2019/6/19
 */
@Component
public class MyListenerA implements ApplicationListener<MyEvent> {


    @Override
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("MyListenerA");
        myEvent.echo();
    }
}
