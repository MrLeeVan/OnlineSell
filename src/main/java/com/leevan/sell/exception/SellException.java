package com.leevan.sell.exception;

import com.leevan.sell.enums.ResultEnum;

/**
 * @Author Leevan
 * @Date： 2019/5/7 14:05
 *
 * 自定义异常类
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum){
        super (resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message){
        super(message);
        this.code = code;
    }

}
