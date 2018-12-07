package com.example.java8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/04 08:52
 */
public class Day2 {

    public static void main(String[] args) throws ParseException {
        // Predicate - 比较，接受一个参数，返回 Boolean
        Predicate<Integer> compare = x -> x > 5;
        System.out.println(compare.test(6));

        // Java 8 为该 ThreadLocal 新加了一个工厂方法， 接受一个 Lambda 表达式， 并产生一个新的 ThreadLocal 对象， 而不用使用继承， 语法上更加简洁。
        // Supplier 工厂方法，无参，返回一个类型
        ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        String format = threadLocal.get().format(new Date());
        System.out.println(format);

        Date parse = threadLocal.get().parse("2018-12-04 09:21:01");
        System.out.println(parse);

        String format1 = new DateFormatUtil("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.println(format1);

        System.out.println("-------------------华丽的分割符-----------------");
        stream();
    }


    //java 8 集合流
    public static void stream() {
        // 1、collect(toList()) 方法由 Stream 里的值生成一个列表， 是一个及早求值操作。
        List<String> list = Stream.of("java", "C++", "Python").collect(Collectors.toList());
        List<String> asList = Arrays.asList("java", "C++", "Python");
        System.out.println(list.equals(asList));

        // 2、filter - 遍历并检查其中的元素。count - 计算集合总数
        long count = list.stream().filter(x -> "java".equals(x)).count();
        System.out.println(count);

        // 3、map - 将一个流中的值转换成一个新的值
        // Function - 表示接受一个参数并生成结果的函数。是只包含一个参数的普通函数接口。
        List<String> mapList = list.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
        mapList.forEach(x -> System.out.println(x));

        //4、flatMap 方法可用 Stream 替换值， 然后将多个 Stream 连接成一个 Stream，可用于双重 for 循环。
        // flatMap 方法的相关函数接口和 map 方法的一样， 都是 Function 接口， 只是方法的返回值限定为 Stream 类型罢了。
        List<String> streamList = Stream.of(list, asList).flatMap(x -> x.stream()).collect(Collectors.toList());
        streamList.forEach(x -> System.out.println("4->" + x));

        //5、Max 求最大值
        String maxStr = list.stream().max(Comparator.comparing(e -> e.length())).get();
        System.out.println(maxStr);

        //6、Min 求最小值
        String minStr = list.stream().min(Comparator.comparing(e -> e.length())).get();
        System.out.println(minStr);


        //7、reduce - 从一组值中生成一个值 - count、min、max 这些方法都是 reduce 操作。
        // Lambda 表达式就是 reducer， 它执行求和操作， 有两个参数： 传入 Stream 中的当前元素和 acc。 将两个参数相加， acc 是累加器， 保存着当前的累加结果
        Integer sum1 = Stream.of(1, 2, 3).reduce(0, (acc, e) -> acc + e);
        Integer sum2 = Stream.of(1, 2, 3).reduce(0, Integer::sum);
        System.out.println(sum1 + "," + sum2);

        BinaryOperator<Integer> operator = (acc, e) -> acc + e;
        Integer apply = operator.apply(operator.apply(operator.apply(0, 1), 2), 3);
        System.out.println(apply);



    }

}
