package com.example.compose;


/**
 * @Description: 菜单项 （叶子节点）
 * @author: cuixiuyin
 * @date: 2018/12/29 09:09
 */
public class MenuItem extends MenuComponent {
    /**
     * 名称
     */
    private String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 是否为素食
     */
    private Boolean vegetarian;
    /**
     * 价格
     */
    private Double price;

    public MenuItem(String name, String description, Boolean vegetarian, Double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Boolean isVegetarian() {
        return vegetarian;
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public void print() {
        System.out.println(" " + getName());
        if (isVegetarian()) {
            System.out.println("(v)");
        }
        System.out.println("," + getPrice());
        System.out.println("--" + getDescription());
    }
}
