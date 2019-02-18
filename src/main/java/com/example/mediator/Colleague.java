package com.example.mediator;

/**
 * @author xiuyin.cui
 * @Description 抽象同事类
 * @date 2019/2/18 12:45
 */
public abstract class Colleague {

    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive(String msg);

    public abstract void send(String msg);
}
