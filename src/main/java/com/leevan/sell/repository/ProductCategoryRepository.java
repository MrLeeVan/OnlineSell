package com.leevan.sell.repository;

import com.leevan.sell.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2019/5/3 17:23
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
      List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
