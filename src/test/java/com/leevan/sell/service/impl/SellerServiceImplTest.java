package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.SellerInfor;
import com.leevan.sell.repository.SellerInfoRepository;
import com.leevan.sell.service.SellerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author Leevan
 * @Date： 2019/5/16 17:09
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SellerServiceImplTest {
    private static final String sellerId = "123";
    @Autowired
    private SellerService sellerService;
    @Test
    public void findBySellerId() {
        SellerInfor sellerInfor = sellerService.findBySellerId( sellerId );
        Assert.assertEquals(sellerId, sellerInfor.getSellerId());
    }
}