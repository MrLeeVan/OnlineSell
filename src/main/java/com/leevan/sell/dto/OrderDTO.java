package com.leevan.sell.dto;

import com.leevan.sell.dataobject.OrderDetail;
import com.leevan.sell.enums.OrderStatusEnum;
import com.leevan.sell.enums.PayStatusEnum;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/6 19:38
 */
@Data
public class OrderDTO {
    /*订单Id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家Openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态,默认为新订单！NEW*/
    private Integer orderStatus;
    /*订单支付状态,默认为未支付！WAIT*/
    private Integer payStatus;
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

    List<OrderDetail> orderDetailList;

}
