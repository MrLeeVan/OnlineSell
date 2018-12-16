package com.leevan.sell.repository;

import com.leevan.sell.dataobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Leevan
 * @Date： 2018/12/16 16:38
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenId(String openId);

    SellerInfo findBySellerId(String sellerId);
}
