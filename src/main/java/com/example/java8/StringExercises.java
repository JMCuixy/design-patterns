package com.example.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/04 21:33
 */
public class StringExercises {

    public static void main(String[] args) {
        int count = countLowercaseLetters("AASSaasdfGDFrt");
        System.out.println(count);
        String str = mostLowercaseString(Stream.of("java", "php", "python")
                .collect(Collectors.toList()));
        System.out.println(str);
    }

    public static int countLowercaseLetters(String string) {
        long count = string.chars().filter(e -> Character.isLowerCase(e)).count();
        return (int) count;
    }

    public static String mostLowercaseString(List<String> list) {
        String str = list.stream().min(Comparator.comparing(e -> countLowercaseLetters(e))).get();
        return str;
    }
}
