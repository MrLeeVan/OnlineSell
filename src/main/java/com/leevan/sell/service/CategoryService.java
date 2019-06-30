package com.leevan.sell.service;

import com.leevan.sell.dataobject.ProductCategory;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2019/5/4 15:54
 */
public interface CategoryService {
    ProductCategory findOne(Integer categoryId);
    List<ProductCategory> findAll();
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
    ProductCategory save(ProductCategory productCategory);
}
