package com.wyyx.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by jt on 2019/10/17 14:30
 */
@Api(tags = "订单管理")
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Reference
    private OrderService orderService;

    @ApiOperation("查询订单")
    @GetMapping(value = "/getOrders")
    public void getOrders() {
        List<Order> orders = orderService.getOrders();
        if (orders.size() > 0) {
            orders.forEach(order -> {
                System.out.println(order);
            });
        } else {
            System.out.println("null");
        }
    }

}
