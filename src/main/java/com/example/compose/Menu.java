package com.example.compose;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Description: 菜单（组合节点）
 * @author: cuixiuyin
 * @date: 2018/12/29 09:19
 */
public class Menu extends MenuComponent {
    /**
     * 可能持有菜单项或其他菜单
     */
    List<MenuComponent> list = new ArrayList<>();

    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        list.add(menuComponent);
    }

    @Override
    public void remove(MenuComponent menuComponent) {
        list.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return list.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    /***
     * @Description 递归 —— 不仅打印出菜单本身的信息，也打印出菜单内所有组件的内容：其他菜单和菜单项目
     * @author cuixiuyin
     * @date 2018/12/29 09:26
     */
    @Override
    public void print() {
        System.out.println("\n" + getName());
        System.out.println("," + getDescription());
        System.out.println("--------------------");
        Iterator<MenuComponent> iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            component.print();
        }
    }
}
