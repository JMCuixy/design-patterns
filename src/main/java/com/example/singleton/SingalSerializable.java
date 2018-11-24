package com.example.singleton;

import java.io.Serializable;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/24 21:09
 */
public class SingalSerializable implements Serializable {


    //内部类方式
    //1、如何保证线程安全: 因为内部的静态类只会被加载一次，只会有一个实例对象，所以是线程安全的。
    //2、java中的内部类是延时加载的，只有在第一次使用时加载，不使用就不加载。
    private static class MyObject {
        private static final SingalSerializable SINGAL_SERIALIZABLE = new SingalSerializable();
    }

    private SingalSerializable() {
    }

    public static SingalSerializable getInstance() {
        return MyObject.SINGAL_SERIALIZABLE;
    }

}
