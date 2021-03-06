package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description 具体请求处理者：村庄处理者
 * @date 2019/2/14 16:55
 */
public class VillageHandler extends Handler {


    @Override
    public void handleRequest(String value) {
        if ("village".equals(value)) {
            System.out.println("village handled~");
            return;
        }
        nextHandler.handleRequest(value);
    }
}
