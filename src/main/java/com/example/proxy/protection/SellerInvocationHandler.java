package com.example.proxy.protection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/24 20:49
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
