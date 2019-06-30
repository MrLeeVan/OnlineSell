package com.leevan.sell.repository;

import com.leevan.sell.dataobject.SellerInfor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author Leevan
 * @Date： 2019/5/16 16:38
 */
public interface SellerInfoRepository extends JpaRepository<SellerInfor, String> {
 /*   SellerInfor findByOpenId(String openId);*/

    SellerInfor findBySellerId(String sellerId);
}
