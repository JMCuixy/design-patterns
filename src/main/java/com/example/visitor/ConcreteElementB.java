package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 具体元素B类
 * @date 2019/2/22 9:43
 */
public class ConcreteElementB implements Element {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationB() {
        return "具体元素B的操作。";
    }
}
