package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 具体访问者B类
 * @date 2019/2/22 9:40
 */
public class ConcreteVisitorB implements Visitor {


    @Override
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->"+element.operationA());
    }

    @Override
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问-->"+element.operationB());
    }
}
