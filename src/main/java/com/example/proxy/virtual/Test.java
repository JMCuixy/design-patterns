package com.example.proxy.virtual;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/30 13:44
 */
public class Test {

    public static void main(String[] args) {
        //1、普通代理
        Subject subject = new RealSubject();
        Proxy proxy = new Proxy(subject);
        proxy.request();

        //2、虚拟代理
        Subject virtualProxy = new VirtualProxy();
        virtualProxy.request();
    }
}
