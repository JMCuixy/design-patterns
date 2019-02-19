package com.example.memento.white;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/18 20:56
 */
public class Test {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

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
