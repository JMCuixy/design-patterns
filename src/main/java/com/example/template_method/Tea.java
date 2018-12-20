package com.example.template_method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/20 12:57
 */
public class Tea extends CaffeineBeverage {

    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }

    /**
    * @Description 子类重写钩子方法
    */
    @Override
    protected boolean wantAddCondiments() {
        return false;
    }
}
