package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 抽象访问者
 * @date 2019/2/22 9:39
 */
public interface Visitor {

    void visit(ConcreteElementA element);

    void visit(ConcreteElementB element);
}
