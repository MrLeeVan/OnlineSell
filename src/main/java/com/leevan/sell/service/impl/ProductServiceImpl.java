package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.dto.CartDTO;
import com.leevan.sell.enums.ProductStatusEnum;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.exception.SellException;
import com.leevan.sell.repository.ProductInfoRepository;
import com.leevan.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * @Author Leevan
 * @Date： 2019/5/4 18:47
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

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        /*加库存，若用户取消订单以后，进行库存返还*/
        for (CartDTO cartDTO: cartDTOList){
            ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result = productInfo.getProductStatus() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    @Transactional  //设置事务。若不成功，进行回滚！
    public void decreaseStock(List<CartDTO> cartDTOList) {
      for (CartDTO cartDTO: cartDTOList){
          ProductInfo productInfo = repository.findOne(cartDTO.getProductId());
          if(productInfo == null ){
              throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
          }
          Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
          if (result < 0 ){
              throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
          }
          productInfo.setProductStock(result);
          repository.save(productInfo);
      }
    }

    @Override
    public ProductInfo onSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
         if (productInfo == null){
             throw new SellException( ResultEnum.PRODUCT_NOT_EXIST );
         }
         if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP){
             throw new SellException( ResultEnum.PRODUCT_STATUS_ERROR );
         }
         productInfo.setProductStatus( ProductStatusEnum.UP.getCode() );
        return repository.save( productInfo );

    }

    @Override
    public ProductInfo offSale(String productId) {
        ProductInfo productInfo = repository.findOne(productId);
        if (productInfo == null){
            throw new SellException( ResultEnum.PRODUCT_NOT_EXIST );
        }
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.DOWN){
            throw new SellException( ResultEnum.PRODUCT_STATUS_ERROR );
        }
        productInfo.setProductStatus( ProductStatusEnum.DOWN.getCode() );
        return repository.save( productInfo );
    }
}
