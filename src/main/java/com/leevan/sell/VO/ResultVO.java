package com.leevan.sell.VO;

/**
 * @Author Leevan
 * @Date： 2018/12/4 20:02
 * http返回给最外层对象
 */
public class ResultVO<T> {
    /*错误码*/
    private  Integer code;
    /*错误信息*/
    private String msg;
    /*返回数据具体内容*/
    private T data;
}
