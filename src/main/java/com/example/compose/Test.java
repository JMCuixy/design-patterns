package com.example.compose;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/29 12:57
 */
public class Test {

    public static void main(String[] args) {
        // 1、创建所有的菜单对象
        MenuComponent breakfast = new Menu("早餐菜单", "Breakfast");
        MenuComponent lunch = new Menu("午餐菜单", "Lunch");
        MenuComponent dinner = new Menu("晚餐菜单", "Dinner");
        MenuComponent dessert = new Menu("晚餐甜点", "Dessert");

        // 2、创建顶层菜单
        MenuComponent top = new Menu("顶层菜单", "Top");
        top.add(breakfast);
        top.add(lunch);
        top.add(dinner);

        // 3、晚餐菜单中加入甜点
        dinner.add(dessert);

        // 4、构建每份菜单中的菜单项（叶子节点）
        breakfast.add(new MenuItem("dumplings", "饺子", false, 10.0));
        breakfast.add(new MenuItem("bread", "面包", true, 7.0));
        breakfast.add(new MenuItem("mile", "牛奶", false, 5.0));

        lunch.add(new MenuItem("rice", "米饭", true, 2.0));
        lunch.add(new MenuItem("burger", "汉堡", false, 6.0));
        lunch.add(new MenuItem("vegetables", "蔬菜", true, 1.0));

        dinner.add(new MenuItem("noodle", "面条", true, 4.0));

        dessert.add(new MenuItem("cake", "蛋糕", true, 3.0));

        // 5、把最顶层的组合给服务员，以便可以获取到所有订单
        Waitress waitress = new Waitress(top);
        waitress.printMenu();

        // 6、打印出所有素食项
        waitress.printVegetarianMenu();
    }

}
