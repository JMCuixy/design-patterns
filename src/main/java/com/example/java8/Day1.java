package com.example.java8;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/03 12:53
 */
public class Day1 {

    public static void main(String[] args) {
        // 接受两个参数，返回两个数的操作结果
        BinaryOperator<Long> add = (x, y) -> x + y;
        Long apply = add.apply(4L, 5L);
        System.out.println(apply);

        List<String> list = Arrays.asList("java", "python", "c++");
        Map<String, String> collect = list.stream().collect(Collectors.toMap(String::new, String::new, (o1, o2) -> o2));
        collect.forEach((k, v) -> System.out.println(k + "," + v));
    }


}
