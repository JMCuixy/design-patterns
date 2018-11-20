package com.example.factory_method;


/**
 * @Description: 抽象产品
 * @author: cuixiuyin
 * @date: 2018/11/19 09:03
 */
public abstract class Pizza {
    /**
     * 披萨的名字
     */
    protected String name;

    protected void bake() {
        System.out.println("烘烤25分钟...");
    }

    protected void cut() {
        System.out.println("把匹萨沿着对角线切开...");
    }

    protected void box() {
        System.out.println("包装用官方标准的盒子...");
    }
}
