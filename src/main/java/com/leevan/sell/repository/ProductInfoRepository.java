package com.leevan.sell.repository;

import com.leevan.sell.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/4 17:14
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    /*查询上架商品*/
    List<ProductInfo> findByProductStatus(Integer productStatus);
}

