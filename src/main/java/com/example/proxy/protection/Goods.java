package com.example.proxy.protection;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/24 20:34
 */
public interface Goods {


    /***
    * @Description 商品的名字、详情、价格 —— 顾客可以查看
    * @author cuixiuyin
    * @date 2019/01/24 20:37
    * @param id
    * @return java.lang.String
    */
    String getName(Long id);

    String getDetail(Long id);

    BigDecimal getPrice(Long id);

    /***
    * @Description 商品的利润 —— 只有商家可以看到
    * @author cuixiuyin
    * @date 2019/01/24 20:38
    *
    * @return java.math.BigDecimal
    */
    BigDecimal getProfit(Long id);
}
