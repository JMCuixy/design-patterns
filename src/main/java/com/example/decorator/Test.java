package com.example.decorator;

import java.io.*;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/14 10:20
 */
public class Test {

    public static void main(String[] args) throws IOException {
        Beverage beverage = new Espresso();
        System.out.println("浓缩咖啡：" + beverage.getDescription() + "," + beverage.cost());

        Beverage beverage1 = new HouseBlend();
        // 抽象装饰者的 "类型匹配" 如下 —— 可以用同一个实例对象接收装饰对象，以达到类行为扩展的目的
        beverage1 = new Mocha(beverage1);
        beverage1 = new Mocha(beverage1);
        System.out.println("混合饮料+2份摩卡：" + beverage1.getDescription() + "," + beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Mocha(beverage2);
        beverage2 = new BigCup(beverage2);
        System.out.println("混合饮料+摩卡+大杯：" + beverage2.getDescription() + "," + beverage2.cost());

        /*---------*/

        InputStream in = new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("E:\\world.txt")));
        int c;
        while ((c = in.read()) > 0) {
            System.out.print((char) c);
        }

    }
}
