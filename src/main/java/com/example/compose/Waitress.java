package com.example.compose;

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
}
