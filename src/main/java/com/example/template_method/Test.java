package com.example.template_method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/20 17:46
 */
public class Test {

    public static void main(String[] args) {
        CaffeineBeverage coffee = new Coffee();
        CaffeineBeverage tea = new Tea();
        coffee.prepareRecipe();
        tea.prepareRecipe();
    }
}
