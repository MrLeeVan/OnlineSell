package com.leevan.sell.dto;

import lombok.Data;

/**
 * @Author Leevan
 * @Date： 2018/12/7 14:51
 *
 *   购物车
 */
@Data
public class CartDTO {
    /*商品Id*/
    private String productId;
    /*商品数量*/
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
