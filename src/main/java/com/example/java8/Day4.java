package com.example.java8;

import javax.sound.midi.Soundbank;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
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

    }

}
