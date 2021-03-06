package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description 具体请求处理者：城镇处理者
 * @date 2019/2/14 16:57
 */
public class TownHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        if ("town".equals(value)) {
            System.out.println("town handled~");
            return;
        }
        nextHandler.handleRequest(value);
    }
}
