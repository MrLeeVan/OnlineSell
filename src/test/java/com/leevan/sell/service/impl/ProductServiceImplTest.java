package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductInfo;
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
 * @Date： 2018/12/4 19:07
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
        ProductInfo productInfo = new ProductInfo("2001",
                "苹果", new BigDecimal( 6 ),150,
                "香甜可口，嘎嘣脆！", "http:xxxx.jpg",
                0, 2);
        ProductInfo result = productService.save( productInfo );
        Assert.assertNotNull( result );
    }
}