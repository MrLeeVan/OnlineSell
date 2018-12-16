package com.leevan.sell.service;

import com.leevan.sell.dataobject.SellerInfo;

/**
 * @Author Leevan
 * @Date： 2018/12/16 17:03
 */
public interface SellerService {
    /**
     * 通过openId查询用户信息
     * @param openId
     * @return
     * */
     SellerInfo findSellerInfoByOpenId(String openId);

     SellerInfo findBySellerId(String sellerId);
}
