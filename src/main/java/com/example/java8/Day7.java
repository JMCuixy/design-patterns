package com.example.java8;

import java.time.*;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoField.INSTANT_SECONDS;

/**
 * @author : cuixiuyin
 * @date : 2019/10/14
 */
public class Day7 {

    public static void main(String[] args) {

        // java 8 的日期库
        // LocalDate 不包含时间的日期
        LocalDate localDate = LocalDate.now();
        System.out.println("LocalDate：" + localDate);
        System.out.println("年份：" + localDate.getYear());
        System.out.println("月份：" + localDate.getMonthValue());
        System.out.println("日期：" + localDate.getDayOfMonth());
        System.out.println("是否为闰年？" + localDate.isLeapYear());
        // 自定义日期时间
        LocalDate of = LocalDate.of(2019, 10, 1);
        LocalDate parse = LocalDate.parse("2019-09-02");
        // 日期加减
        LocalDate days = parse.plusMonths(1L).minusDays(1L);
        // 日期比较
        System.out.println(of);
        System.out.println(days);
        System.out.println(of.isBefore(days));
        System.out.println(of.isAfter(days));
        System.out.println(of.equals(days));

        System.out.println("---------------------");

        // LocalTime 不包含日期的时间
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);

        System.out.println("---------------------");

        // LocalDateTime 包含了日期及时间，没有偏移信息（时区），相当于 java.util.Calendar 类
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDateTime atTime = localDate.atTime(LocalTime.MAX);
        LocalDateTime atDate = localTime.atDate(LocalDate.of(2019, 10, 14));
        System.out.println(atTime);
        System.out.println(atDate);

        System.out.println("---------------------");

        // ZonedDateTime 包含时区的完整的日期时间，偏移量是以UTC/格林威治时间为基准的。
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println("---------------------");
        // Instant 相当于 java.util.Date 类
        Instant instant = Instant.now();
        long getLong = instant.getLong(INSTANT_SECONDS);
        System.out.println(getLong);


        System.out.println("---------------------");
        // Duration 时间段
        Duration.between(atTime, atDate);
        Duration.ofDays(7);

        System.out.println("---------------------");

        // 时间日期格式化，相当于 java.text.SimpleDateFormat
        LocalDateTime dateTime = LocalDateTime.now();
        String str;
        str = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        System.out.println(str);
        str = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    }
}
