package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.Order;

import java.util.List;

/**
 * Created by jt on 2019/10/17 14:42
 */
public interface OrderService {
    //查询所有订单并分页
    List<Order> getOrders(Order order);

    //查询所有订单的数量
    long totalOrderList(Order order);

    //根据订单状态查询，并分页
    List<Order> getOrderByStatus(Order order);

    //根据订单状态查总数
    int statusOrderList(Order order);

    //根据已完成订单或者已确认收货但未评价的才可以删除到回收站
    boolean updateOrderStatus(Order order);

    //从回收站删除就彻底删除
    boolean delOrder(Long orderId);

    //模糊查询
    List<Order> getOrdersByLike(Order order);

    Integer totalByLike(Order order);
}
