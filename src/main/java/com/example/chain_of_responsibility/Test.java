package com.example.chain_of_responsibility;

/**
 * @author xiuyin.cui
 * @Description
 * @date 2019/2/14 17:04
 */
public class Test {

    public static void main(String[] args) {
        Handler village = new VillageHandler();
        Handler town = new TownHandler();
        Handler county = new CountyHandler();
        Handler reject = new RejectHandler();
        // 构建责任链
        village.setNextHandler(town);
        town.setNextHandler(county);
        county.setNextHandler(reject);
        // 处理请求
        village.handleRequest("village");
        village.handleRequest("town");
        village.handleRequest("county");
        village.handleRequest("sss");
    }
}
