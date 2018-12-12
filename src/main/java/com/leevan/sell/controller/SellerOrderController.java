package com.leevan.sell.controller;

import com.leevan.sell.dto.OrderDTO;
import com.leevan.sell.service.OrderService;
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
@RequestMapping("/seller/order")
public class SellerOrderController {
    @Autowired
    private OrderService orderService;
    /*
    * 订单列表
    * @param page 第几页 从第一页开始；
    * @param size 一页有多少条数据
    * @return
    * */
    @GetMapping("/list")
     public ModelAndView list(@RequestParam (value = "page" ,defaultValue = "1") Integer page,
                              @RequestParam (value = "size" , defaultValue = "2") Integer size,
                              Map<String, Object> map){
         PageRequest request = new PageRequest(page-1, size);
         Page<OrderDTO> orderDTOPage =  orderService.findList(request);
         map.put("orderDTOPage",orderDTOPage);
         return new ModelAndView("order/list",map);

     }
}
