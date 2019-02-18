package com.example.mediator;

/**
 * @author xiuyin.cui
 * @Description 具体同事类 B
 * @date 2019/2/18 12:51
 */
public class ConcreteColleagueB extends Colleague {

    @Override
    public void receive(String msg) {
        System.out.println("具体同事 B 收到请求..." + msg);
    }

    @Override
    public void send(String msg) {
        System.out.println("具体同事 B 发出请求..." + msg);
        // 请求中介者转发
        mediator.relay(this, msg);
    }
}
