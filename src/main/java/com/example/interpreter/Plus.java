package com.example.interpreter;

/**
 * @author xiuyin.cui
 * @Description 非终结符表达式 —— 加号
 * @date 2019/2/16 10:13
 */
public class Plus implements IExpression {

    private IExpression left, right;

    public Plus(IExpression left, IExpression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Integer interpret(Context ctx) {
        return left.interpret(ctx) + right.interpret(ctx);
    }

    @Override
    public String toString() {
        return left.toString() + " + " + right.toString();
    }
}
