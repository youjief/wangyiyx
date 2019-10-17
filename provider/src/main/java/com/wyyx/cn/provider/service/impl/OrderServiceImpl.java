package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.mapper.OrderMapper;
import com.wyyx.cn.provider.model.Order;
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
    public List<Order> getOrders() {
        List<Order> orderList = orderMapper.getOrderList();
        if (orderList.size() > 0) {
            return orderList;
        }
        return null;
    }

}
