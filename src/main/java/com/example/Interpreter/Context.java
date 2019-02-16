package com.example.Interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiuyin.cui
 * @Description 上下文 - 存放临时数据
 * @date 2019/2/16 10:28
 */
public class Context {

    private Map<String,Integer> map = new HashMap();

    public void assign(String var , int value){
        map.put(var, new Integer(value));
    }

    public Integer lookup(String var) throws IllegalArgumentException{
        Integer value = map.get(var);
        if(value == null){
            throw new IllegalArgumentException();
        }
        return value;
    }
}
