package com.example.factory.absc;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/19 09:32
 */
public class CheesePizza extends Pizza {
    public CheesePizza() {
        name = "这是一个奶酪披萨";
    }

    @Override
    protected void bake() {
        System.out.println("烘烤30分钟...");
    }

    @Override
    protected void cut() {
        System.out.println("把匹萨按四等分切开...");
    }

    @Override
    protected void box() {
        System.out.println("包装用奶酪披萨特制的盒子...");
    }
}
