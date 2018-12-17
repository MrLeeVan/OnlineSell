package com.leevan.sell.service;
import com.leevan.sell.dataobject.SellerInfor;

/**
 * @Author Leevan
 * @Date： 2018/12/16 17:03
 */
public interface SellerService {
    /*
     * 通过openId查询用户信息
     * @param openId
     * @return
     * */
    /* SellerInfor findSellerInfoByOpenId(String openId);*/

     SellerInfor findBySellerId(String sellerId);
}
