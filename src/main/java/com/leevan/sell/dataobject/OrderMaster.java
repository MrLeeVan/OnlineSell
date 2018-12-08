package com.leevan.sell.dataobject;

import com.leevan.sell.enums.OrderStatusEnum;
import com.leevan.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Leevan
 * @Date： 2018/12/6 14:50
 * 订单总表
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {
    @Id
    /*订单Id*/
    private String orderId;
    /*买家名字*/
    private String buyerName;
    /*买家电话*/
    private String buyerPhone;
    /*买家地址*/
    private String buyerAddress;
    /*买家Openid*/
    private String buyerOpenid;
    /*订单总金额*/
    private BigDecimal orderAmount;
    /*订单状态,默认为新订单！NEW*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();
    /*订单支付状态,默认为未支付！WAIT*/
    private Integer payStatus = PayStatusEnum.WAIT.getCode();
    /*创建时间*/
    private Date createTime;
    /*更新时间*/
    private Date updateTime;

   /* @Transient  //进行数据库映射的时候将其忽略掉
    可以用DTO代替
    private List<OrderDetail> orderDetailList;*/

}
