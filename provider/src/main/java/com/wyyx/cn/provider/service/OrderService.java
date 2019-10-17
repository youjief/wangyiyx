package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.Order;

import java.util.List;

/**
 * Created by jt on 2019/10/17 14:42
 */
public interface OrderService {
    //查询所有订单
    List<Order> getOrders();
}
