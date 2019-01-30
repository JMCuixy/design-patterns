package com.example.proxy.virtual;

/**
 * @Description: 虚拟代理
 */
public class VirtualProxy implements Subject {

    private Subject subject;

    @Override
    public void request() {
        // 在真正使用的时候才创建对象
        if (subject == null) {
            subject = new RealSubject();
        }
        subject.request();
    }
}
