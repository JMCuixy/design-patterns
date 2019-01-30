package com.example.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description: 商家 — 可以看到所有资源
 */
public class SellerInvocationHandler implements InvocationHandler {

    private Goods goods;

    public SellerInvocationHandler(Goods goods) {
        this.goods = goods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(goods, args);
    }
}
