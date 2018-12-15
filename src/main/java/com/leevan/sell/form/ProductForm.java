package com.leevan.sell.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author Leevan
 * @Date： 2018/12/15 16:29
 */
@Data
public class ProductForm {
    /*商品ID*/
    private String productId;
    /*商品名称*/
    private String productName;
    /*商品单价*/
    private BigDecimal productPrice;
    /*商品库存*/
    private Integer productStock;
    /*商品描述*/
    private String productDescription;
    /*商品展示图*/
    private String productIcon;
    /*商品状态（0上架/1下架）*/
/*   private Integer productStatus = 0;*/
    /*商品类目*/
    private Integer categoryType;

}
