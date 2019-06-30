package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.SellerInfor;
import com.leevan.sell.repository.SellerInfoRepository;
import com.leevan.sell.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Leevan
 * @Date： 2019/5/16 17:07
 */
@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoRepository sellerInfoRepository;
   /* @Override
    public SellerInfor findSellerInfoByOpenId(String openId) {
        return sellerInfoRepository.findByOpenId( openId );
    }*/

    @Override
    public SellerInfor findBySellerId(String sellerId) {
        return sellerInfoRepository.findBySellerId( sellerId );
    }
}
