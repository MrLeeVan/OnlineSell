package com.leevan.sell.controller;

import com.leevan.sell.dto.OrderDTO;
import com.leevan.sell.enums.ResultEnum;
import com.leevan.sell.exception.SellException;
import com.leevan.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;

/**
 * @Author Leevan
 * @Date： 2018/12/12 16:30
 * 卖家端订单
 */
@Controller
@Slf4j
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    private OrderService orderService;
    /**
    * 订单列表
    * @param page 第几页 从第一页开始；
    * @param size 一页有多少条数据
    * @return
    * */
    @GetMapping("/list")
     public ModelAndView list(@RequestParam (value = "page" ,defaultValue = "1") Integer page,
                              @RequestParam (value = "size" , defaultValue = "10") Integer size,
                              Map<String, Object> map){
         PageRequest request = new PageRequest(page-1, size);
         Page<OrderDTO> orderDTOPage =  orderService.findList(request);
         /*orderDTOPage.getTotalPages();   获取页数*/
         map.put("orderDTOPage",orderDTOPage);
         map.put( "currentPage", page );
         map.put( "size", size );
         return new ModelAndView("order/list",map);
     }
    /**
     * 卖家订单取消
     * @param orderId ；
     * @param map
     * @return
     * */
    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam ("orderId") String orderId,
                                Map<String, Object> map){
        try{
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel( orderDTO );
        }catch(SellException e) {
            log.error( "【卖家端取消订单】 发生异常{}" , e );
            map.put( "msg", e.getMessage() );
            map.put( "url", "/sell/seller/order/list" );
            return new ModelAndView( "common/error", map );
        }

         map.put( "msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage() );
         map.put( "url", "/sell/seller/order/list" );
         //TODO  操作后跳转到当前页
        return new ModelAndView( "/common/success",map );
    }
    /**
     * 订单详情
     * @param orderId ；
     * @param map
     * @return
     * */
    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId")String orderId,
                               Map<String, Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try{
             orderDTO = orderService.findOne( orderId );
        }catch(SellException e){
            log.error( "【卖家端查询订单】 发生异常{}" , e );
            map.put( "msg", e.getMessage() );
            map.put( "url", "/sell/seller/order/list" );
            return new ModelAndView( "common/error", map );
        }
        map.put( "orderDTO", orderDTO );
        return new ModelAndView( "order/detail",map );
    }
    /**
     * 卖家订单完结
     * @param orderId ；
     * @param map
     * @return
     * */
    @RequestMapping("/finish")
    public ModelAndView finish(@RequestParam("orderId") String orderId,
                               Map<String, Object> map){
        try{
            OrderDTO orderDTO = orderService.findOne( orderId );
            orderService.finish( orderDTO );
        }catch(SellException e){
            log.error("【卖家端订单完结异常】 发生异常{}", e);
            map.put( "msg", e.getMessage() );
            map.put( "url", "/sell/seller/order/list" );
            return new ModelAndView( "common/error", map );
        }
        map.put( "msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put( "url", "/sell/seller/order/list");
        return new ModelAndView( "/common/success" );
    }
}
