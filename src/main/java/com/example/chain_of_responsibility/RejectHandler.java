package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/14 17:03
 */
public class RejectHandler extends Handler {

    @Override
    public void handleRequest(String value) {
        System.out.println("Unable to handle request.reject~");
    }
}
