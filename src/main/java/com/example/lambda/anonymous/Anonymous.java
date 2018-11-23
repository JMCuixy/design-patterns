package com.example.lambda.anonymous;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/23 09:29
 */
public class Anonymous {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(123)).start();
    }
}
