package com.example.memento.black;

/**
 * @author xiuyin.cui
 * @Description 备忘录管理者角色
 * @date 2019/2/19 9:59
 */
public class Caretaker {

    private IMemento memento;

    /**
     * 获取备忘录
     */
    public IMemento getMemento() {
        return this.memento;
    }

    /**
     * 保存备忘录
     */
    public void setMemento(IMemento memento) {
        this.memento = memento;
    }
}
