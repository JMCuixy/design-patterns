package com.example.memento.white;

/**
 * @author xiuyin.cui
 * @Description 备忘录发起者角色
 * @date 2019/2/18 20:47
 */
public class Originator {

    private String state;

    /**
     * 创建一个当前状态的备忘录对象
     */
    public Memento createMemento() {
        return new Memento(state);
    }

    /**
     * 恢复状态
     */
    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }

}
