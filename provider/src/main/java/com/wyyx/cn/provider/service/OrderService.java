package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.Order;

import java.util.List;

/**
 * Created by jt on 2019/10/17 14:42
 */
public interface OrderService {
    //查询所有订单并分页
    List<Order> getOrders(int startItem, int pageSize);

    //查询所有订单的数量
    int totalOrderList();

    //根据订单状态查询，并分页
    List<Order> getOrderByStatus(int orderStatus,int startItem, int pageSize);

    //根据订单状态查总数
    int statusOrderList(int orderStatus);
}
