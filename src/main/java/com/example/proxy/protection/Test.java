package com.example.proxy.protection;

import java.lang.reflect.Proxy;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/24 20:51
 */
public class Test {

    /**
     * 1、Java 在 java.lang.reflect 包中有自己的代理支持，利用这个包你可以在运行时动态的创建一个代理类，实现一个或多个接口，并将
     * 方法的调用转发到你所指定的类。因为实际的代理类是在运行时创建的，我们称这个Java技术为：动态代理。
     * 2、InvocationHandler 的工作是响应代理的任何调用。你可以把 InvocationHandler 想成是代理收到方法调用后，请求做实际工作的对象。
     */
    public static void main(String[] args) {
        Goods goods = new Clothes();
        // 创建顾客代理
        Goods customer = (Goods) Proxy.newProxyInstance(goods.getClass().getClassLoader(),
                goods.getClass().getInterfaces(),
                new CustomerInvocationHandler(goods));
        // 创建卖家代理
        Goods seller = (Goods) Proxy.newProxyInstance(goods.getClass().getClassLoader(),
                goods.getClass().getInterfaces(),
                new SellerInvocationHandler(goods));
        // 判断某个类是不是代理类
        System.out.println(Proxy.isProxyClass(customer.getClass()));

        // 卖家代理调用
        System.out.println("-------卖家代理调用开始--------");
        System.out.println(seller.getName(800001L));
        System.out.println(seller.getDetail(800001L));
        System.out.println(seller.getPrice(800001L).doubleValue());
        System.out.println(seller.getProfit(800001L).doubleValue());
        System.out.println("-------卖家代理调用结束--------");

        // 顾客代理调用
        System.out.println("-------顾客代理调用开始--------");
        System.out.println(customer.getName(800001L));
        System.out.println(customer.getDetail(800001L));
        System.out.println(customer.getPrice(800001L).doubleValue());
        System.out.println(customer.getProfit(800001L).doubleValue());
        System.out.println("-------顾客代理调用结束--------");
    }
}
