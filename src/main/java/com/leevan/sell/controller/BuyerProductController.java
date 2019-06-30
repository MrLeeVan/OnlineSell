package com.leevan.sell.controller;

import com.leevan.sell.VO.ProductInfoVO;
import com.leevan.sell.VO.ProductVO;
import com.leevan.sell.VO.ResultVO;
import com.leevan.sell.dataobject.ProductCategory;
import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.service.CategoryService;
import com.leevan.sell.service.ProductService;
import com.leevan.sell.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Leevan
 * @Date： 2019/5/4 19:58
 *
 * 买家商品
 */
@RestController //返回json格式
@RequestMapping("/buyer/product")
public class BuyerProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    public ResultVO list(){
        /*1.查询上架商品*/
        List<ProductInfo> productInfoList = productService.findUpAll();
        /*2.查询类目（一次性查询)*/
        /*传统方法*/
        //       List<Integer> categoryTypeList = new ArrayList<>();
        //      for (ProductInfo productInfo: productInfoList){
        //          categoryTypeList.add(productInfo.getCategoryType());
        //      }
        /*精简方法 Java8 lambda*/
        List<Integer> categoryTypeList = productInfoList.stream().
                map(e ->e.getCategoryType()).collect(Collectors.toList());
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryTypeList);

        /*3.数据拼装*/
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory: productCategoryList){
            ProductVO productVO = new ProductVO();
            productVO.setCategoryType(productCategory.getCategoryType());
            productVO.setCategoryName(productCategory.getCategoryName());

            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for ( ProductInfo productInfo: productInfoList ){
                if (productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }

            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }
}
