package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 抽象元素类
 * @date 2019/2/22 9:41
 */
public interface Element {

    void accept(Visitor visitor);
}
