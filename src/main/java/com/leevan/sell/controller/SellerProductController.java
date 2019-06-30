package com.leevan.sell.controller;

import com.leevan.sell.dataobject.ProductCategory;
import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.exception.SellException;
import com.leevan.sell.form.ProductForm;
import com.leevan.sell.service.CategoryService;
import com.leevan.sell.service.ProductService;
import com.leevan.sell.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author Leevan
 * @Date： 2019/5/14 16:49
 */
@Controller
@Slf4j
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;
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
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map){
        if (!StringUtils.isEmpty( productId )){
            ProductInfo productInfo = productService.findOne( productId );
            map.put( "productInfo", productInfo );
        }
        List<ProductCategory> categoryList = categoryService.findAll() ;
        map.put( "categoryList", categoryList );
        return new ModelAndView( "product/index", map );
    }
    /**
     * 商品信息更新
     * @param form
     * @param bindingResult
     * @param map
     * @return
     * */
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if(bindingResult.hasErrors()){
            map.put( "msg", bindingResult.getFieldError().getDefaultMessage() );
            map.put( "url", "/sell/seller/product/index" );
            return new ModelAndView( "common/error", map );
        }
        ProductInfo productInfo = new ProductInfo(  );
        /*如果表单传来的productId数据为空，则为新增数据！*/
        if (!StringUtils.isEmpty( form.getProductId() )){
            /*productId不为空，通过id查询到记录*/
            productInfo = productService.findOne( form.getProductId() );
        }else{
            form .setProductId( KeyUtil.genUniqueKey() );
        }
        BeanUtils.copyProperties( form, productInfo );
        try{
            productService.save( productInfo );
        }catch(SellException e){
         map.put( "msg", e.getMessage() );
         map.put( "url", "/sell/seller/product/index" );
         return new ModelAndView( "common/error", map );
        }
        map.put( "url", "/sell/seller/product/list" );
        return new ModelAndView( "common/success", map );
    }
}
