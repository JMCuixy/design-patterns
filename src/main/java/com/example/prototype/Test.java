package com.example.prototype;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/20 21:26
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        Student stu1 = new Student("张三", 24);
        System.out.println(stu1.toString());
        Student stu2 = (Student) stu1.clone();
        System.out.println(stu2.toString());

        System.out.println(stu1 == stu2);
        System.out.println(stu1.getClass().equals(stu2.getClass()));

    }
}
