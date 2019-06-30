package com.leevan.sell.utils;

import com.leevan.sell.enums.CodeEnum;

/**
 * @Author Leevan
 * @Date： 2019/5/13 12:46
 */
public class EnumUtils {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass){
        for(T each: enumClass.getEnumConstants()){
            if (code.equals( each.getCode() )){
                return each;
            }
        }
        return null;
    }
}
