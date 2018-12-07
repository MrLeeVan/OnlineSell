package com.leevan.sell.service;

import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/4 18:31
 * 商品
 */
public interface ProductService {
    ProductInfo findOne(String productId);
    /*
    * 查询所有上架商品
    * @return
    * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    /*加库存*/
    void increaseStock(List<CartDTO> cartDTOList);
    /*减库存*/
    void decreaseStock(List<CartDTO> cartDTOList);
}
