package com.leevan.sell.service;

import com.leevan.sell.dataobject.OrderMaster;
import com.leevan.sell.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author Leevan
 * @Date： 2019/5/6 19:32
 *订单层逻辑
 */
public interface OrderService {
    /*创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /*查询单个订单*/
    OrderDTO findOne(String orderId);
    /*查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);
    /*取消订单*/
    OrderDTO cancel(OrderDTO orderDTO);
    /*完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /*支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
    /*查询订单列表、卖家查询方法*/
    Page<OrderDTO> findList( Pageable pageable);

}

