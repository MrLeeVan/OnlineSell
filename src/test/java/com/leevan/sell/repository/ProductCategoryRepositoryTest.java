package com.leevan.sell.repository;


import com.leevan.sell.dataobject.ProductCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;



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

    public void findOneTest(){
    ProductCategory productCategory = repository.findOne( 1 );
    System.out.println(productCategory.toString());
}
@Test
@Transactional   /*设置回滚，测试通过后删除数据库中留下的记录！*/
    public void saveTest(){
    ProductCategory productCategory = new ProductCategory("热销榜",1);
    ProductCategory result = repository.save( productCategory );
    Assert.assertNotNull( result );
}
@Test
    public void updateTest(){
    ProductCategory productCategory = repository.findOne( 2 );
    productCategory.setCategoryName( "热销榜" );
    productCategory.setCategoryType( 2 );
    repository.save(productCategory);

}
@Test
    public void findByCategoryTypeInTest(){
    List<Integer> list = Arrays.asList(2,1);
    List<ProductCategory> result = repository.findByCategoryTypeIn( list );
    Assert.assertNotEquals( 0,result.size() );

}
}