package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.mapper.OrderMapper;
import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.model.OrderExample;
import com.wyyx.cn.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by jt on 2019/10/17 18:48
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getOrders(int startItem, int pageSize) {
        List<Order> orderList = orderMapper.getOrderList(startItem, pageSize);
        if (orderList.size() > 0) {
            return orderList;
        }
        return null;
    }

    @Override
    public int totalOrderList() {
        return orderMapper.totalOrderList();
    }

    @Override
    public List<Order> getOrderByStatus(int orderStatus, int startItem, int pageSize) {
        List<Order> orderList = orderMapper.getOrderByStatus(orderStatus, startItem, pageSize);
        if (orderList.size() > 0) {
            return orderList;
        }
        return null;
    }

    @Override
    public int statusOrderList(int orderStatus) {
        return orderMapper.statusOrderList(orderStatus);
    }

}
