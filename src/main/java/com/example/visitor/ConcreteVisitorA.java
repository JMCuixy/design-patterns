package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 具体访问者A类
 * @date 2019/2/22 9:39
 */
public class ConcreteVisitorA implements Visitor {

    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->" + element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}
