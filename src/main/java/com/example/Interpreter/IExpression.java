package com.example.Interpreter;

/**
 * @author xiuyin.cui
 * @Description 抽象表达式接口
 * @date 2019/2/16 10:08
 */
public interface IExpression {

    /**
     * 解释操作
     */
    Integer interpreter(Context ctx);

}
