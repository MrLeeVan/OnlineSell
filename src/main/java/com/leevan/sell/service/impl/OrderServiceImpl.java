package com.leevan.sell.service.impl;

import com.leevan.sell.dataobject.OrderDetail;
import com.leevan.sell.dataobject.OrderMaster;
import com.leevan.sell.dataobject.ProductInfo;
import com.leevan.sell.dto.CartDTO;
import com.leevan.sell.dto.OrderDTO;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.exception.SellException;
import com.leevan.sell.repository.OrderDetailRepository;
import com.leevan.sell.repository.OrderMasterRepository;
import com.leevan.sell.service.OrderService;
import com.leevan.sell.service.ProductService;
import com.leevan.sell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author Leevan
 * @Date： 2018/12/6 19:46
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional  //设置事务。若不成功，进行回滚！
    public OrderDTO create(OrderDTO orderDTO) {
        /*定义订单总价*/
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        String orderId = KeyUtil.genUniqueKey();

/*   aa.获取购物车信息（方法一
     List<CartDTO> cartDTOList = new ArrayList<>();
     */

        /*1.查询商品（数量、价格）*/
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()){
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
        /*2.计算订单总价*/
        orderAmount = productInfo.getProductPrice().
                multiply(new BigDecimal(orderDetail.
                        getProductQuantity())).add(orderAmount);
        /*订单详情入库*/
            orderDetail.setOrderId(orderId);
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            BeanUtils.copyProperties(productInfo,orderDetail);
            orderDetailRepository.save(orderDetail);

/*      aa.获取购物车信息（方法一
            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
            cartDTOList.add(cartDTO);*/
        }

        /*3.写入订单数据库（OrderMaster和OrderDetail）*/
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        BeanUtils.copyProperties(orderDTO, orderMaster);

        orderMasterRepository.save(orderMaster);

        /*4.扣库存*/
/* aa.获取购物车信息（方法一
       productService.decreaseStock(cartList);*/
        /*bb.获取购物车信息（方法二*/
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().
                stream().map(e ->new CartDTO(e.getProductId(),
                e.getProductQuantity())).collect(Collectors.toList());
        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
