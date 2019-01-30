package com.example.proxy.virtual;

/**
 * @Description:具体主题 — 真正做事的地方
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("this is real subject.");
    }
}
