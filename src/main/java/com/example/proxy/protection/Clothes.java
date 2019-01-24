package com.example.proxy.protection;

import java.math.BigDecimal;

/**
 * @Description:
 * @author: cuixiuyin
 * @date: 2019/01/24 20:39
 */
public class Clothes implements Goods {

    @Override
    public String getName(Long id) {
        return "西装";
    }

    @Override
    public String getDetail(Long id) {
        return "西装详情";
    }

    @Override
    public BigDecimal getPrice(Long id) {
        return new BigDecimal(new Double(119.9));
    }

    @Override
    public BigDecimal getProfit(Long id) {
        return new BigDecimal(new Double(44.2));
    }
}
