package com.example.state;

/**
 * @Description: 抽象状态
 * @author: cuixiuyin
 * @date: 2019/01/16 08:57
 */
public interface State {

    /***
     * @Description 乘客下单，订单创建
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCreate();

    /***
     * @Description 乘客取消，订单取消
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderCancel();

    /***
     * @Description 司机接单，订单匹配
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void orderMatch();

    /***
     * @Description 乘客评价，订单结束
     * @author cuixiuyin
     * @date 2019/01/16 08:59
     */
    void evaluation();

}
