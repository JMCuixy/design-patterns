package com.example.memento.black;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/19 10:12
 */
public class Test {

    public static void main(String[] args) {
        Caretaker caretaker = new Caretaker();
        Originator originator = new Originator();

        //改变发起人对象的状态
        originator.setState("stateA");
        //创建备忘录对象，并将发起人对象的状态储存起来
        caretaker.setMemento(originator.createMemento());
        //修改发起人的状态
        originator.setState("stateB");
        //恢复发起人对象的状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复状态：" + originator.getState());

    }
}
