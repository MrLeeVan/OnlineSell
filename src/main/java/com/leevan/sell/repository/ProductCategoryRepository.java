package com.leevan.sell.repository;

import com.leevan.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Leevan
 * @Date： 2018/12/3 17:23
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {

}
