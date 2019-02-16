package com.example.interpreter;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/16 10:16
 */
public class Test {

    /**
     * @Description 解释表达式：x + 5 = 9，其中 x = 4
     */
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.assign("x", 4);

        IExpression left = new Variable("x");
        IExpression right = new Constant(5);
        IExpression plus = new Plus(left, right);
        System.out.println(plus.toString() + " = " + plus.interpreter(ctx));

    }
}
