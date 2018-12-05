package com.leevan.sell.repository;

import com.leevan.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Leevan
 * @Date： 2018/12/4 18:00
 */
@SpringBootTest
@RunWith( SpringRunner.class )
public class ProductInfoRepositoryTest {
@Autowired
private ProductInfoRepository repository;
    @Test
    public void saveTest(){
        ProductInfo productInfo = new ProductInfo("1001",
                "西瓜", new BigDecimal( 11 ),150,
                "清凉可口，冰镇西瓜！", "http:xxxx.jpg",
                0, 2);

        ProductInfo result = repository.save( productInfo );
        Assert.assertNotNull(result);
    }
    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = repository.findByProductStatus( 0 );
        Assert.assertNotEquals( 0,productInfoList.size() );

    }
}