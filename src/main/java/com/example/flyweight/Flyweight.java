package com.example.flyweight;

/**
 * @author xiuyin.cui
 * @Description 无可共享内部状态的具体蝇量
 * @date 2019/2/15 17:52
 */
public class Flyweight implements IFlyweight {

    private String id;

    public Flyweight(String id) {
        this.id = id;
    }

    @Override
    public void print() {
        System.out.println("Flyweight.id = " + this.id + " ...");
    }


}
