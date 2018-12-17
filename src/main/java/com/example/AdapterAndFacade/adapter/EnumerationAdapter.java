package com.example.AdapterAndFacade.adapter;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

/**
 * 1、Iterator 是目标（Target）接口角色。
 * 2、Enumeration 是被适配者（Apaptee）角色。
 * 3、EnumerationAdapter 是适配者（Adapter）角色。
 */
public class EnumerationAdapter implements Iterator {

    private Enumeration enumeration;

    public EnumerationAdapter(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }

    public static void main(String[] args) {
        Vector vector = new Vector();
        vector.add("java");
        vector.add("python");
        vector.add("javaScript");
        Enumeration enumeration = vector.elements();
        Iterator iterator = new EnumerationAdapter(enumeration);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
