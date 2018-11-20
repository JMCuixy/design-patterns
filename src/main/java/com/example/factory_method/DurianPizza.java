package com.example.factory_method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/19 09:36
 */
public class DurianPizza extends Pizza {
    public DurianPizza() {
        name = "这是一个榴莲披萨";
    }
    @Override
    protected void bake() {
        System.out.println("烘烤45分钟...");
    }
    @Override
    protected void cut() {
        System.out.println("把匹萨按三等分切开...");
    }
    @Override
    protected void box() {
        System.out.println("包装用榴莲披萨特制的盒子...");
    }
}
