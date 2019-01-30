package com.example.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: 顾客 InvocationHandler
 */
public class CustomerInvocationHandler implements InvocationHandler {

    private Goods goods;

    public CustomerInvocationHandler(Goods goods) {
        this.goods = goods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("getName".equals(method.getName())
                || "getDetail".equals(method.getName())
                || "getPrice".equals(method.getName())) {
            return method.invoke(goods, args);
        }
        if ("getProfit".equals(method.getName())) {
            throw new IllegalAccessException();
        }
        return null;
    }
}
