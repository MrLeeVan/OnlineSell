package com.leevan.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.leevan.sell.enums.PayStatusEnum;
import com.leevan.sell.enums.ProductStatusEnum;
import com.leevan.sell.utils.EnumUtils;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Leevan
 * @Date： 2018/12/4 16:55
 * 商品信息
 */
@Entity
@DynamicUpdate
@Data
public class ProductInfo {
    @Id
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
    private Integer productStatus = ProductStatusEnum.UP.getCode();
    /*商品类目*/
    private Integer categoryType; private  Date createTime;

    private Date updateTime;



    public  ProductInfo() {/*默认构造方法*/
    }

    public ProductInfo(String productId, String productName, BigDecimal productPrice, Integer productStock, String productDescription, String productIcon, Integer productStatus, Integer categoryType) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.productDescription = productDescription;
        this.productIcon = productIcon;
        this.productStatus = productStatus;
        this.categoryType = categoryType;
    }
    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum(){
        return EnumUtils.getByCode( productStatus, ProductStatusEnum.class );
    }

}
