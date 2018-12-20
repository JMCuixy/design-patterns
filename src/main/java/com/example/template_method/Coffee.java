package com.example.template_method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/20 12:58
 */
public class Coffee extends CaffeineBeverage {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Suger and Milk");
    }
}
