package com.leevan.sell.controller;

import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.exception.SellException;
import com.leevan.sell.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @Author Leevan
 * @Date： 2018/12/14 16:49
 */
@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductService productService;
    /**
     * 订单列表
     * @param page 第几页 从第一页开始；
     * @param size 一页有多少条数据
     * @return
     * */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                              @RequestParam(value = "size", defaultValue = "5") Integer size,
                             Map<String, Object> map){
        PageRequest request = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage =  productService.findAll(request );
        /*orderDTOPage.getTotalPages();   获取页数*/
        map.put("productInfoPage",productInfoPage);
        map.put( "currentPage", page );
        map.put( "size", size );
        return new ModelAndView("product/list",map);

    }

    /**
     *商品上架
     * @param productId
     * @param map
     * @return
    * */
    @GetMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("productId") String productId,
                                Map<String, Object> map){
        try{
            ProductInfo productInfo = productService.findOne(productId);
            productService.onSale( productId );
        }catch(SellException e) {
            log.error( "【修改商品状态】 发生异常{}" , e );
            map.put( "msg", e.getMessage() );
            map.put( "url", "/sell/seller/product/list" );
            return new ModelAndView( "common/error", map );
        }
        map.put( "msg", ResultEnum.PRODUCT_STATUS_CHANGE_SUCCESS.getMessage() );
        map.put( "url", "/sell/seller/product/list" );
        //TODO  操作后跳转到当前页
        return new ModelAndView( "/common/success",map );
    }
    /**
     *商品下架
     * @param productId
     * @param map
     * @return
     * */
    @GetMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("productId") String productId,
                                Map<String, Object> map){
        try{
            ProductInfo productInfo = productService.findOne(productId);
            productService.offSale( productId );
        }catch(SellException e) {
            log.error( "【修改商品状态】 发生异常{}" , e );
            map.put( "msg", e.getMessage() );
            map.put( "url", "/sell/seller/product/list" );
            return new ModelAndView( "common/error", map );
        }
        map.put( "msg", ResultEnum.PRODUCT_STATUS_CHANGE_SUCCESS.getMessage() );
        map.put( "url", "/sell/seller/product/list" );
        //TODO  操作后跳转到当前页
        return new ModelAndView( "/common/success",map );
    }

}
