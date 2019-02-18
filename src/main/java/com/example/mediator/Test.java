package com.example.mediator;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/18 12:55
 */
public class Test {

    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        Colleague colleagueA = new ConcreteColleagueA(), colleagueB = new ConcreteColleagueB();
        mediator.register(colleagueA);
        mediator.register(colleagueB);
        colleagueA.send("A 请求");
        System.out.println("-------------");
        colleagueB.send("B 请求");
    }
}
