package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description 具体元素A类
 * @date 2019/2/22 9:42
 */
public class ConcreteElementA implements Element {

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String operationA() {
        return "具体元素A的操作。";
    }
}
