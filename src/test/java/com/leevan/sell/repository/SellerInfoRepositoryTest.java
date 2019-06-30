package com.leevan.sell.repository;

import com.leevan.sell.dataobject.SellerInfor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author Leevan
 * @Date： 2019/5/16 16:40
 */
@SpringBootTest
@RunWith( SpringRunner.class )
public class SellerInfoRepositoryTest {
    @Autowired
    private SellerInfoRepository repository;

    @Test
    public void saveTest(){
        SellerInfor sellerInfo = new SellerInfor("124","van","123");
        SellerInfor result = repository.save( sellerInfo );
        Assert.assertNotNull(result);
    }
   /* @Test
    public void findByOpenId() {
        SellerInfor sellerInfo = repository.findByOpenId( "123l" );
        System.out.println(sellerInfo.getOpenId());
        Assert.assertNotEquals(0, sellerInfo);
    }*/
}