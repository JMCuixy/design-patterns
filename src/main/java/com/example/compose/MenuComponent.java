package com.example.compose;

import java.util.Iterator;

/**
 * @Description: 组件的抽象类，菜单组件的角色是为叶节点和组合节点提供一个公共的接口。
 * @author: cuixiuyin
 * @date: 2018/12/29 08:59
 */
public abstract class MenuComponent {

    /**
     * @Description 组合节点（菜单）的方法组织在一起
     * @author cuixiuyin
     * @date 2018/12/29 09:03
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    /**
     * @Description 叶子节点（菜单项）的方法组织在一起、其中有一些也可以用于组合节点（菜单）上
     * @author cuixiuyin
     * @date 2018/12/29 09:03
     */
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public Double getPrice() {
        throw new UnsupportedOperationException();
    }

    public Boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    /**
     * @Description 相关操作
     * @author cuixiuyin
     * @date 2019/01/02 09:04
     */
    public void print() {
        throw new UnsupportedOperationException();
    }

    /***
     * @Description 组合迭代器，遍历整个树结构
     * @author cuixiuyin
     * @date 2018/12/29 21:25
     */
    public Iterator<MenuComponent> createIterator() {
        return new NullIterator();
    }
}
