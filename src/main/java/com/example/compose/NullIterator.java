package com.example.compose;

import java.util.Iterator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/29 21:26
 */
public class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }
}
