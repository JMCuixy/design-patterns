package com.example.memento.white;

/**
 * @author xiuyin.cui
 * @Description 备忘录管理者
 * @date 2019/2/18 20:39
 */
public class Caretaker {

    private Memento memento;

    /**
     * 获取备忘录
     */
    public Memento getMemento() {
        return this.memento;
    }

    /**
     * 保存备忘录
     */
    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
