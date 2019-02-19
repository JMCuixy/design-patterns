package com.example.memento.black;

/**
 * @author xiuyin.cui
 * @Description 备忘录发起者
 * @date 2019/2/19 9:46
 */
public class Originator {

    private String state;

    /**
     * 创建备份
     */
    public IMemento createMemento() {
        return new Memento(state);
    }

    /**
     * 恢复备份
     */
    public void restoreMemento(IMemento memento) {
        this.state = ((Memento) memento).getState();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
        System.out.println("当前状态：" + this.state);
    }


    private class Memento implements IMemento {

        private String state;

        public Memento(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }
    }

}
