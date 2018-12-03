package com.leevan.sell.repository;

import com.leevan.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author Leevan
 * @Date： 2018/12/3 17:25
 */
@RunWith( SpringRunner.class )
@SpringBootTest
public class ProductCategoryRepositoryTest {
@Autowired
    private ProductCategoryRepository repository;
@Test
    public void findOne(){
    ProductCategory productCategory = repository.findOne( 1 );
    System.out.println(productCategory.toString());
}
}