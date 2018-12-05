package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author Leevan
 * @Date： 2018/12/4 16:03
 */
@SpringBootTest
@RunWith( SpringRunner.class )
public class CategoryServiceImplTest {
    @Autowired
    private  CategoryServiceImpl categoryService;

    @Test
    public void findOne() throws Exception{
        ProductCategory productCategory = categoryService.findOne( 7 );
        Assert.assertEquals( new Integer( 7 ),productCategory.getCategoryId() );
    }

    @Test
    public void findAll() throws Exception{
        List<ProductCategory> productCategoryList = categoryService.findAll();
        Assert.assertNotEquals( 0,productCategoryList.size() );
    }

    @Test
    public void findByCategoryTypeIn() throws Exception{
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn( Arrays.asList(7,8,9) );
        Assert.assertNotEquals( 0,productCategoryList.size() );

    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory( "热销榜",2 );
        ProductCategory result = categoryService.save( productCategory );
        Assert.assertNotNull( result );
    }
}