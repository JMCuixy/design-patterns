package com.example.java8;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/12 09:24
 */
public class Day5 {

    public static void main(String[] args) {
        Day5 day5 = new Day5();
        System.out.println(day5.countPrimes(10));

        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList());


        Stream.of("java", "python", "php").forEach(e -> System.out.println(e));
        Stream.of("java", "python", "php").forEachOrdered(e -> System.out.println(e));
        System.out.println("--------------------------------------------------------");
        Stream.of("java", "python", "php", "java").distinct().forEach(e -> System.out.println(e));
        Optional<String> first = Stream.of("java", "python", "php").findFirst();
        Optional<String> any = Stream.of("java", "python", "php").findAny();
    }


    public long countPrimes(int upTo) {
        return IntStream.range(1, upTo)
                .filter(this::isPrime)
                .count();
    }

    private boolean isPrime(int number) {
        return IntStream.range(2, number)
                .allMatch(x -> (number % x) != 0);
    }
}
