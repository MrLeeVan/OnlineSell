package com.leevan.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Author Leevan
 * @Date： 2019/5/6 15:20
 * 订单详情表
 */
@Data
@Entity
public class OrderDetail {
    /*订单总表Id*/
    @Id
    private String detailId;
    /*订单Id*/
    private String orderId;
    /*商品Id*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*商品单价*/
    private BigDecimal productPrice;
    /*商品数量*/
    private Integer productQuantity;
    /*商品小图*/
    private String productIcon;
}
