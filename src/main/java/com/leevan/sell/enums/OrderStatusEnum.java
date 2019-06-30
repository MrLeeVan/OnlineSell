package com.leevan.sell.enums;

import lombok.Getter;

/**
 * @Author Leevan
 * @Date： 2019/5/6 14:58
 * 订单状态枚举
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0,"新订单"),
    FINISHED(1,"订单完结"),
    CANCEL(2,"订单取消");

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }



}
