package com.leevan.sell.controller;

import com.leevan.sell.dataobject.SellerInfo;
import com.leevan.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author Leevan
 * @Date： 2018/12/16 19:32
 */
@RequestMapping("/seller/UI")
@Controller
public class SellerLoginController {
    @Autowired
    private SellerService sellerService;

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("sellerName" )String sellerId,
                              @RequestParam("password")String password,
                              Map<String, Object> map){
        SellerInfo sellerInfo = sellerService.findBySellerId( sellerId );
        if(sellerInfo.getPassword().equals( sellerId )){
           //TODO  未完成  登录界面设计！FreeMark
        }
        return null;
    }
}
