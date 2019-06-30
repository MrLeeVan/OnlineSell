package com.leevan.sell.VO;

import lombok.Data;

/**
 * @Author Leevan
 * @Date： 2019/5/4 20:02
 * http返回给最外层对象
 */
@Data
public class ResultVO<T> {
    /*错误码*/
    private  Integer code;
    /*错误信息*/
    private String msg;
    /*返回数据具体内容*/
    private T data;
}
