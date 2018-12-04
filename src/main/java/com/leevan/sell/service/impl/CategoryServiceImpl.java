package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductCategory;
import com.leevan.sell.repository.ProductCategoryRepository;
import com.leevan.sell.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/4 15:58
 * 类目
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    ProductCategoryRepository repository;
    @Override
    public ProductCategory findOne(Integer categoryId) {
        return repository.findOne( categoryId );
    }

    @Override
    public List<ProductCategory> findAll() {
        return repository.findAll();
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return repository.findByCategoryTypeIn( categoryTypeList );
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) { return repository.save( productCategory );
    }
}
