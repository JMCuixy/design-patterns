package com.example.java8;

import javax.sound.midi.Soundbank;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/07 21:20
 */
public class Day4 {

    public static void main(String[] args) {
        // 1、利用收集器转换成其他集合
        List<String> collect = Stream.of("java", "python", "php").collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e));

        Set<String> collectSet = collect.stream().collect(Collectors.toSet());

        Map<String, String> strMap = collect.stream().collect(Collectors.toMap(String::new, String::new, (o1, o2) -> o2));

        //2、对 Stream 进行自定义排序
        List<String> collectSort = collect.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        collectSort.forEach(e -> System.out.println(e));

        // 3、利用收集器转换成自定义集合
        TreeSet<String> treeSet = collect.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        treeSet.stream().forEach(e -> System.out.println(e));

        // 4、利用收集器转换成值
        Function<String, Integer> function = str -> str.length();
        Optional<String> optionalMaxBy = collect.stream().collect(Collectors.maxBy(Comparator.comparing(function)));
        System.out.println(optionalMaxBy.get());

        Optional<String> optionalMinBy = collect.stream().collect(Collectors.minBy(Comparator.comparing(function)));
        System.out.println(optionalMinBy.get());

        Double aDouble = collect.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(aDouble);

        // 5、数据分块
        Map<Boolean, List<String>> listMap = collect.stream().collect(Collectors.partitioningBy(str -> str.equals("java")));
        List<String> javaList = listMap.get(true);
        javaList.forEach(e -> System.out.println(e));
        List<String> otherList = listMap.get(false);
        otherList.forEach(e -> System.out.println(e));

        // 6、数据分组
        Map<Integer, List<String>> collectGroudBy = collect.stream().collect(Collectors.groupingBy(String::hashCode));

        // 7、拼接字符串
        String joinStr = collect.stream().map(String::new).collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinStr);

        // 8、组合收集器 - 先将集合分组，然后统计分组的值
        Map<Integer, Long> longMap = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        longMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        Map<Integer, List<Integer>> longMap2 = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.mapping(String::length, Collectors.toList())));
        longMap2.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

}
