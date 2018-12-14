package com.leevan.sell.repository;

import com.leevan.sell.dataobject.OrderDetail;
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
 * @Date： 2018/12/6 19:16
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class  OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository repository;
    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("112233");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("http:xxx.jpg");
        orderDetail.setProductId("11111112");
        orderDetail.setProductName("西瓜皮");
        orderDetail.setProductPrice(new BigDecimal(8.1));
        orderDetail.setProductQuantity(3);
        OrderDetail result = repository.save(orderDetail);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByOrderId() throws Exception{
        List<OrderDetail> orderDetailList = repository.findByOrderId("123456");
        Assert.assertNotEquals(0,orderDetailList.size());

    }
}