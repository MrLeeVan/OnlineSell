package com.leevan.sell.enums;

import lombok.Getter;

/**
 * @Author Leevan
 * @Date： 2018/12/4 18:55
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
