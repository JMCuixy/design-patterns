package com.example.java8;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/05 12:50
 */
public class Day3 {


    public static void main(String[] args) {
        // 1、mapToInt、mapToLong、mapToDouble 统计值
        List<String> list = Stream.of("java", "javascript", "python").collect(Collectors.toList());
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(e -> e.length()).summaryStatistics();
        System.out.println("最大值：" + intSummaryStatistics.getMax());
        System.out.println("最小值：" + intSummaryStatistics.getMin());
        System.out.println("平均值：" + intSummaryStatistics.getAverage());
        System.out.println("总数：" + intSummaryStatistics.getSum());

        // 2、
        list.forEach(e -> System.out.println(e));

        // 3、Optional
        Optional<Object> empty = Optional.empty();
        if (empty.isPresent()) {
            System.out.println(empty.get());
        }
        Optional<Object> ofnullable = Optional.ofNullable("abc");
        System.out.println(ofnullable.get());

        Optional<String> qwe = Optional.ofNullable(null);
        String qweStr = qwe.orElse("yyy");
        System.out.println(qweStr);

        String qweStr2 = qwe.orElseGet(() -> "ooo");
        System.out.println(qweStr2);

    }
}
