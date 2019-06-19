package com.example.observer.spring;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author : cuixiuyin
 * @date : 2019/6/19
 */
@Component
public class MyListenerB {

    @EventListener
    public void onApplicationEvent(MyEvent myEvent) {
        System.out.println("MyListenerB");
        myEvent.echo();
    }

}
