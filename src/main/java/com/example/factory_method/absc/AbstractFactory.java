package com.example.factory_method.absc;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2018/11/22 09:28
 */
public interface AbstractFactory {
    /**
     * @Description 奶酪披萨制造接口
     */
    Pizza createCheese();

    /**
     * @Description 榴莲披萨制造接口
     */
    Pizza createDurian();
}
