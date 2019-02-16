package com.example.interpreter;

/**
 * @author xiuyin.cui
 * @Description 终结符表达式 —— 变量
 * @date 2019/2/16 10:10
 */
public class Variable implements IExpression {

    private String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public Integer interpreter(Context ctx) {
        return ctx.lookup(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
