package com.leevan.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leevan.sell.dataobject.OrderDetail;
import com.leevan.sell.enums.OrderStatusEnum;
import com.leevan.sell.enums.PayStatusEnum;
import com.leevan.sell.utils.Serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/6 19:38
 */
@Data
/*@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)*/
/*@JsonInclude(JsonInclude.Include.NON_NULL)  //判断数据是否为Null ，如果是Null则不返回！*/
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
    @JsonSerialize(using = Date2LongSerializer.class)  //使用注解，将毫秒变为秒
    private Date createTime;
    /*更新时间*/
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    List<OrderDetail> orderDetailList;

}
