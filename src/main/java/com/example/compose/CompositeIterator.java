package com.example.compose;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.Stack;

/**
 * @Description: 组合迭代器，遍历整个树结构
 * @author: cuixiuyin
 * @date: 2018/12/29 21:30
 */
public class CompositeIterator implements Iterator {
    private Stack<Iterator> stack = new Stack();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        }
        Iterator peek = stack.peek();
        if (peek.hasNext()) {
            return true;
        }
        stack.pop();
        return hasNext();
    }

    @Override
    public MenuComponent next() {
        if (hasNext()) {
            Iterator peek = stack.peek();
            MenuComponent component = (MenuComponent) peek.next();
            if (component instanceof Menu) {
                stack.push(component.createIterator());
            }
            return component;
        }
        return null;
    }
}
