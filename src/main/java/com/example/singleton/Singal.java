package com.example.singleton;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/24 20:43
 */
public class Singal {

    private static volatile Singal singal;

    private Singal() {

    }

    /**
     * Double Check - 饱汉式加载模式
     *
     * @return com.example.singleton.Single
     * @Description
     * @author cuixiuyin
     * @date 2018/11/24 20:46
     */
    public static Singal getSingle() {
        if (singal == null) {
            synchronized (Singal.class) {
                if (singal == null) {
                    singal = new Singal();
                }
            }
        }
        return singal;
    }

}
