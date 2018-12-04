package com.example.java8;

import javax.swing.text.DateFormatter;
import java.nio.channels.NonReadableChannelException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/04 08:52
 */
public class Day2 {

    public static void main(String[] args) throws ParseException {
        // 比较，返回 Boolean
        Predicate<Integer> compare = x -> x > 5;
        System.out.println(compare.test(6));

        // Java 8 为该 ThreadLocal 新加了一个工厂方法， 接受一个 Lambda 表达式， 并产生一个新的 ThreadLocal 对象， 而不用使用继承， 语法上更加简洁。
        // Supplier 工厂方法，返回一个类型
        ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String format = threadLocal.get().format(new Date());
        System.out.println(format);

        Date parse = threadLocal.get().parse("2018-12-04 09:21:01");
        System.out.println(parse);

        String format1 = new DateFormatUtil("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format1);


    }

}
