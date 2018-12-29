package com.example.compose;

import java.util.Iterator;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/29 09:28
 */
public class Waitress {

    private MenuComponent menuComponent;

    public Waitress(MenuComponent menuComponent) {
        this.menuComponent = menuComponent;
    }

    public void printMenu() {
        menuComponent.print();
    }

    /***
     * @Description 迭代整个树形菜单，打印出为素食的菜单项
     * @author cuixiuyin
     * @date 2018/12/29 21:46
     */
    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = menuComponent.createIterator();
        System.out.println("--VEGETARIAN MENU--");
        while (iterator.hasNext()) {
            MenuComponent component = iterator.next();
            try {
                if (component.isVegetarian()) {
                    component.print();
                }
            } catch (UnsupportedOperationException e) {

            }
        }
    }
}
