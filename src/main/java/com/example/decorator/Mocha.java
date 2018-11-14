package com.example.decorator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/14 09:01
 */
public class Mocha extends CondimentDecorator {

    public Mocha(Beverage b) {
        beverage = b;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + "+Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }

    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println("浓缩咖啡：" + beverage.getDescription() + "," + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        // 抽象装饰者的 "类型匹配" 如下：
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println("混合饮料+摩卡：" + beverage1.getDescription() + "," + beverage1.cost());


    }
}
