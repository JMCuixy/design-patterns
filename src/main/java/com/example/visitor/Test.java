package com.example.visitor;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/22 9:47
 */
public class Test {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());

        Visitor visitorA = new ConcreteVisitorA();
        os.accept(visitorA);
        System.out.println("------------------------");
        Visitor visitorB = new ConcreteVisitorB();
        os.accept(visitorB);
    }
}
