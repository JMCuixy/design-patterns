package com.example.builder;

import lombok.Data;

/**
 * @author xiuyin.cui
 * @Description 产品类 —— Product
 * @date 2019/02/14 16:12
 * @return
 */
@Data
public class House {

    /**
     * 地基
     */
    private String foundation;

    /**
     * 墙
     */
    private String wall;

    /**
     * 屋顶
     */
    private String roof;


    @Override
    public String toString() {
        return "House{" +
                "foundation='" + foundation + '\'' +
                ", wall='" + wall + '\'' +
                ", roof='" + roof + '\'' +
                '}';
    }
}
