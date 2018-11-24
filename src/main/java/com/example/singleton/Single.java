package com.example.singleton;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/24 20:43
 */
public class Single {

    private static volatile Single single;

    private Single() {

    }

    /**
     * Double Check
     *
     * @return com.example.singleton.Single
     * @Description
     * @author cuixiuyin
     * @date 2018/11/24 20:46
     */
    public static Single getSingle() {
        if (single == null) {
            synchronized (Single.class) {
                if (single == null) {
                    single = new Single();
                }
            }
        }
        return single;
    }

}
