package com.leevan.sell.enums;

import lombok.Getter;

/**
 * @Author Leevan
 * @Date： 2018/12/7 14:06
 * 商品状态枚举类
 */
@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIST(10,"商品不存在！"),
    PRODUCT_STOCK_ERROR(11,"商品库存不足！")
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
