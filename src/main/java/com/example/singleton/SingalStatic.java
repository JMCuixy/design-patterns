package com.example.singleton;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/24 21:15
 */
public class SingalStatic {

    public static final SingalStatic SINGAL_STATIC = new SingalStatic();

    private SingalStatic() {

    }

    /***
    * @Description 饿汉式加载模式
    * @author cuixiuyin
    * @date 2018/11/24 21:18
    *
    * @return com.example.singleton.SingalStatic
    */
    public static SingalStatic getInstance() {
        return SINGAL_STATIC;
    }

}
