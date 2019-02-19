package com.example.memento.white;

/**
 * @author xiuyin.cui
 * @Description 备忘录角色
 * @date 2019/2/18 20:40
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
