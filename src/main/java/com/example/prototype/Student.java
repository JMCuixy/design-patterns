package com.example.prototype;

/**
 * @author xiuyin.cui
 * @Description 具体原型类，其中 cloneable 为抽象原型类
 * @date 2019/2/20 21:24
 */
public class Student implements Cloneable {

    private String name;
    private Integer age;

    public Student() {

    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
