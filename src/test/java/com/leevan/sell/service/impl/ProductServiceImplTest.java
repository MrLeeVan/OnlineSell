package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;


/**
 * @Author Leevan
 * @Date： 2019/5/4 19:07
 */
@SpringBootTest
@RunWith( SpringRunner.class )
public class ProductServiceImplTest {
    @Autowired
    private ProductServiceImpl productService ;

    @Test
    public void findOne() {
        ProductInfo productInfo = productService.findOne( "1001" );
        Assert.assertEquals("1001",productInfo.getProductId());
    }

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = productService.findUpAll();
        Assert.assertNotEquals( 0,productInfoList.size() );
    }

    @Test
    public void findAll1() throws Exception{
        PageRequest request = new PageRequest( 0,2 );
        Page<ProductInfo> productInfoPage = productService.findAll( request );
       // System.out.println(productInfoPage.getTotalElements());
        Assert.assertNotEquals( 0,productInfoPage.getTotalElements() );
    }

    @Test
    public void save() {
        ProductInfo productInfo = new ProductInfo("4002",
                "珍珠奶茶", new BigDecimal( 6 ),150,
                "香香的口味", "http:xxxx.jpg",
                0, 4);
        ProductInfo result = productService.save( productInfo );
        Assert.assertNotNull( result );
    }
    @Test
    public void onSale(){
        ProductInfo result = productService.onSale( "1001" );
        Assert.assertEquals( ProductStatusEnum.UP, result.getProductStatusEnum() );
    }
    @Test
    public void offSale(){
        ProductInfo result = productService.offSale( "1001" );
        Assert.assertEquals( ProductStatusEnum.DOWN, result.getProductStatusEnum() );
    }
}