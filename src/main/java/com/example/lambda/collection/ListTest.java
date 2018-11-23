package com.example.lambda.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/23 09:33
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("java", "python", "c++");
        list.forEach(e -> System.out.println(e));
        list.stream().map(e -> e + ",add").forEach(e -> System.out.println(e));
        System.out.println(list.stream().reduce((sum, x) -> sum + x).get());
        List<String> java = list.stream().filter(e -> e.equals("java")).collect(Collectors.toList());
        java.forEach(e -> System.out.println(e));

    }
}
