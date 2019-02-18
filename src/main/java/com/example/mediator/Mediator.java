package com.example.mediator;

/**
 * @author xiuyin.cui
 * @Description 抽象中介者
 * @date 2019/2/18 12:44
 */
public abstract class Mediator {

    public abstract void register(Colleague colleague);

    //转发
    public abstract void relay(Colleague colleague, String msg);
}
