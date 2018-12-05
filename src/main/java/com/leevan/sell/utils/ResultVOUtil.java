package com.leevan.sell.utils;

import com.leevan.sell.VO.ResultVO;

/**
 * @Author Leevan
 * @Date： 2018/12/5 18:46
 */
public class ResultVOUtil {
    public static ResultVO success (Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }
    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }
}
