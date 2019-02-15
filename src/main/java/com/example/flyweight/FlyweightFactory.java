package com.example.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiuyin.cui
 * @Description 蝇量工厂
 * @date 2019/2/15 17:53
 */
public class FlyweightFactory {

    private Map<String, IFlyweight> flyweightMap = new HashMap();

    public IFlyweight getFlyweight(String str) {
        IFlyweight flyweight = flyweightMap.get(str);
        if (flyweight == null) {
            flyweight = new Flyweight(str);
            flyweightMap.put(str, flyweight);
        }
        return flyweight;
    }

    public int getFlyweightMapSize() {
        return flyweightMap.size();
    }
}
