package com.example.template_method;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/12/20 12:51
 */
public abstract class CaffeineBeverage {

    /**
     * @Description 1、模板方法，定义算法的步骤。
     * 2、我们一般把模板方法定义成 final，不希望子类覆盖。
     */
    public final void prepareRecipe() {
        //1、把水煮沸
        boilWater();
        //2、用热水泡饮料（具体什么饮料未知）
        brew();
        //3、把饮料倒进杯子
        pourIncup();
        //4、往饮料中添加调料（具体什么调料未知）
        if (wantAddCondiments()) {
            addCondiments();
        }

    }

    /**
     * @Description 需要子类提供实现的步骤定义为抽象
     */
    protected abstract void brew();

    protected abstract void addCondiments();

    /**
     * @Description 由父类提供实现，又不希望被子类重写的，封装成 private。
     */
    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourIncup() {
        System.out.println("Pouring into cup");
    }


    /**
     * @Description 钩子方法
     * 1、钩子是一种被声明在抽象类中的方法，当只有空的或者默认的实现。
     * 2、钩子的存在，可以让子类有能力对算法的不同点进行挂钩（重写）。
     * 3、要不要挂钩（重写），由子类自己决定。
     */
    protected boolean wantAddCondiments() {
        return true;
    }
}
