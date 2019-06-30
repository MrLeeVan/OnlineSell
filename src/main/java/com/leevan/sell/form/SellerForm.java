package com.leevan.sell.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author Leevan
 * @Date： 2019/5/17 14:54
 */
@Data
public class SellerForm {

    /*卖家用户id*/
    private String sellerId;
    /*卖家用户姓名*/
    private String userName;
    /*买家登录密码*/
    private String password;
}
