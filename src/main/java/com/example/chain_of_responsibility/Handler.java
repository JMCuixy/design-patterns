package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description 抽象请求处理者
 * @date 2019/2/14 16:52
 */
public abstract class Handler {

    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public Handler nextHandler() {
        return this.nextHandler;
    }

    public abstract void handleRequest(String value);
}
