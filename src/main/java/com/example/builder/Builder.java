package com.example.builder;

/**
 * @author xiuyin.cui
 * @Description 抽象建造者 - Builder
 * @date 2019/02/14 16:16
 * @return
 */
public interface Builder {

    /**
     * 打基础
     */
    void buildFoundation();

    /**
     * 砌墙
     */
    void buildWall();

    /**
     * 封顶
     */
    void buildRoof();

    /**
     * 造房子
     */
    House getHouse();
}
