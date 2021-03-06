package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description 具体请求处理者：城市处理者
 * @date 2019/2/14 17:00
 */
public class CountyHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        if ("county".equals(value)) {
            System.out.println("country handled~");
            return;
        }
        nextHandler.handleRequest(value);
    }
}
