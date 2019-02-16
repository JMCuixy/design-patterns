package com.example.interpreter;

/**
 * @author xiuyin.cui
 * @Description 终结符表达式 —— 常量
 * @date 2019/2/16 10:10
 */
public class Constant implements IExpression {

    private Integer value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public Integer interpreter(Context ctx) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
