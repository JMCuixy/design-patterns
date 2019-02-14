package com.example.builder;

/**
 * @author xiuyin.cui
 * @Description 指导者
 * @date 2019/2/14 16:30
 */
public class Director {

    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public House buildHouse() {
        return builder.getHouse();
    }
}
