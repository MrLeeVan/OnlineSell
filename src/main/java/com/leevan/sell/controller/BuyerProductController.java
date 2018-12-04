package com.leevan.sell.controller;

import com.leevan.sell.VO.ResultVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Leevan
 * @Date： 2018/12/4 19:58
 *
 * 买家商品
 */
@RestController //返回json格式
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @GetMapping("/list")
    public ResultVO list(){
     ResultVO resultVO = new ResultVO();
     return resultVO;
    }
}
