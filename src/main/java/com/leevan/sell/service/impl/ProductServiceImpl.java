package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.enums.ProductStatusEnum;
import com.leevan.sell.repository.ProductInfoRepository;
import com.leevan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/4 18:47
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findOne( productId );
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus( ProductStatusEnum.UP.getCode() );
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll( pageable );
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save( productInfo );
    }
}
