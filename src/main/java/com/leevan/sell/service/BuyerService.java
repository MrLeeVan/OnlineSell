package com.leevan.sell.service;

import com.leevan.sell.dto.OrderDTO;

/**
 * @Author Leevan
 * @Date： 2018/12/10 17:14
 * 买家
 */
public interface BuyerService {
    /*查询一个订单*/
    OrderDTO findOrderOne(String openid, String orderId);
    /*取消订单*/
    OrderDTO cancelOrder(String openid, String orderId);
}
