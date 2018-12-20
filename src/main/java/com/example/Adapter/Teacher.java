package com.example.Adapter;

import lombok.Data;


/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/17 09:14
 */
@Data
public class Teacher {
    private Subject subject;

    public String getSubjectName() {
        return getSubject().getName();
    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        String name = teacher.getSubjectName();
        System.out.println(name);
    }
}
