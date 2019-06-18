package com.example.builder;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/14 16:31
 */
public class Test {

    public static void main(String[] args) {
        ConcreteBuilderA builderA = new ConcreteBuilderA();
        ConcreteBuilderB builderB = new ConcreteBuilderB();
        Director director = new Director();
        // 调用 A 构造者
        director.setBuilder(builderA);
        System.out.println(director.buildHouse());
        // 调用 B 构造者
        director.setBuilder(builderB);
        System.out.println(director.buildHouse());
    }
}
