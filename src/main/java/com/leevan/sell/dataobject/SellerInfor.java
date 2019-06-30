package com.leevan.sell.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author Leevan
 * @Date： 2019/5/16 13:55
 */
@Entity
@Data
public class SellerInfor {
    @Id
    /*卖家用户id*/
    private String sellerId;
    /*卖家用户姓名*/
    private String userName;
    /*买家登录密码*/
    private String password;
  /*  *//*卖家访问OpenId*//*
    private String openId;*/
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;
    public SellerInfor(){
        /*默认构造方法*/
    }
    public SellerInfor(String sellerId, String userName, String password) {
        this.sellerId = sellerId;
        this.userName = userName;
        this.password = password;
    /*    this.openId = openId;*/

    }
}
