package com.example.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/13 18:05
 */
public class Day6 {

    public static void main(String[] args) {
        List<String> paraList = Stream.of("java", "php", "python").parallel().collect(Collectors.toList());
        List<String> resultList = paraList.parallelStream().collect(Collectors.toList());
    }
}
