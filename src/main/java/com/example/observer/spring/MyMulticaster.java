package com.example.observer.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.core.ResolvableType;

/**
 * @author : cuixiuyin
 * @date : 2019/6/19
 */
public class MyMulticaster implements ApplicationEventMulticaster {

    @Override
    public void addApplicationListener(ApplicationListener<?> applicationListener) {

    }

    @Override
    public void addApplicationListenerBean(String s) {

    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> applicationListener) {

    }

    @Override
    public void removeApplicationListenerBean(String s) {

    }

    @Override
    public void removeAllListeners() {

    }

    @Override
    public void multicastEvent(ApplicationEvent applicationEvent) {

    }

    @Override
    public void multicastEvent(ApplicationEvent applicationEvent, ResolvableType resolvableType) {

    }
}
