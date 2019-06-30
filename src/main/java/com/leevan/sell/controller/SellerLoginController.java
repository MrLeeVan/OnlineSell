package com.leevan.sell.controller;

import com.leevan.sell.dataobject.ProductCategory;
import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.dataobject.SellerInfor;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.form.SellerForm;
import com.leevan.sell.service.CategoryService;
import com.leevan.sell.service.ProductService;
import com.leevan.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * @Author Leevan
 * @Date： 2019/5/16 19:32
 */
@RequestMapping("/seller/UI")
@Controller
public class SellerLoginController {
    @Autowired
    private SellerService sellerService;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    /**
     * 商品上架
     *
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "sellerId", required = false) String sellerId,
                              Map<String, Object> map) {
        if (!StringUtils.isEmpty( sellerId )){
            SellerInfor sellerInfor = sellerService.findBySellerId( sellerId );
            map.put( "sellerInfo", sellerInfor );
        }
        return new ModelAndView( "UI/index", map );
    }


    @GetMapping("/login")
    public ModelAndView login(@RequestParam(value = "sellerId", defaultValue = "123") String sellerId,
            Map<String, Object> map) {
        SellerInfor sellerInfor = sellerService.findBySellerId( sellerId);
        if (sellerInfor == null) {
            map.put( "msg", ResultEnum.LOGIN_FAIL.getMessage() );
            map.put( "url", "/sell/seller/UI/index" );
            return new ModelAndView( "common/error", map );
        }
        map.put( "url", "/sell/seller/UI/index" );
        return new ModelAndView( "common/success", map );
    }

}