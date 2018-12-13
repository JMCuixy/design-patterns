package com.example.java8;

import java.util.*;
import java.util.function.Function;
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

        Set<String> collectSet = Stream.of("java", "python", "php").collect(Collectors.toSet());

        Map<String, String> strMap = Stream.of("java", "python", "php").collect(Collectors.toMap(String::new, String::new, (oldValue, newValue) -> oldValue));

        Map<Object, Object> mapResult = Stream.of("java", "python", "php").collect(HashMap::new, (map, str) -> map.put(str, str), HashMap::putAll);

        //2、对 Stream 进行自定义排序
        List<String> collectSort = collect.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        collectSort.forEach(e -> System.out.println(e));

        // 3、利用收集器转换成自定义集合
        TreeSet<String> treeSet = collect.stream().collect(Collectors.toCollection(() -> new TreeSet<>()));
        treeSet.stream().forEach(e -> System.out.println(e));

        // 4、利用收集器转换成值
        Optional<String> optionalMaxBy = Stream.of("java", "python", "php").collect(Collectors.maxBy(Comparator.comparing(str -> str.length())));
        System.out.println(optionalMaxBy.get());

        Optional<String> optionalMinBy = Stream.of("java", "python", "php").collect(Collectors.minBy(Comparator.comparing(str -> str.length())));
        System.out.println(optionalMinBy.get());

        Double aDouble = Stream.of("java", "python", "php").collect(Collectors.averagingInt(String::length));
        System.out.println(aDouble);

        // 5、数据分堆，按照 Boolean 值，将数据分成两堆
        Map<Boolean, List<String>> listMap = collect.stream().collect(Collectors.partitioningBy(str -> str.equals("java")));
        List<String> javaList = listMap.get(true);
        javaList.forEach(e -> System.out.println(e));
        List<String> otherList = listMap.get(false);
        otherList.forEach(e -> System.out.println(e));

        // 6、 数据分组，有点像 SQL 的 GROUP BY 用法，按照对象的某个属性分组
        Map<Integer, List<String>> collectGroudBy = collect.stream().collect(Collectors.groupingBy(String::hashCode));

        // 7、拼接字符串
        String joinStr = Stream.of("java", "python", "php").collect(Collectors.joining(",", "[", "]"));
        System.out.println(joinStr);

        // 8、分组统计（类似SQL分组统计） - 先将集合分组，然后统计分组的值 - 比如计算每个城市的姓氏集合-> 先按城市分组，再计算姓氏的集合。
        Map<Integer, Long> longMap = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        longMap.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        Map<Integer, List<Integer>> longMap2 = collect.stream().collect(Collectors.groupingBy(String::length, Collectors.mapping(String::length, Collectors.toList())));
        longMap2.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        // 9 computeIfAbsent
        Map<String, String> map = new HashMap<>(8);
        map.put("java", "java");
        map.put("php", "php");
        String python = map.computeIfAbsent("python", k -> k.toUpperCase());

        // 10 数组上的并行化操作
        // parallelPrefix 任意给定一个函数， 计算数组的和
        // parallelSetAll 使用 Lambda 表达式更新数组元素
        // parallelSort 并行化对数组元素排序
        double[] values = new double[10];
        Arrays.parallelSetAll(values, i -> i);
        for (double v : values) {
            System.out.print(v);
        }
        System.out.println();

    }

}
