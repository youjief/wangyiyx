package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.mapper.OrderMapper;
import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.model.OrderExample;
import com.wyyx.cn.provider.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 2019/10/17 18:48
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询全部订单，并根据支付时间降序排列；
     * 排除已删除（到回收站的）订单，限制条件写在了SQL语句里
     * @param order
     * @return
     */
    @Override
    public List<Order> getOrders(Order order) {
        /*String orderByClause = "pay_time DESC";
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(order.getUserId());
        orderExample.setOrderByClause(orderByClause);*/

        List<Order> orderList = orderMapper.getOrderList(order);
        if (orderList.size() > 0) {
            return orderList;
        }
        return null;
    }


    /**
     * 统计全部订单数量，排除已删除（到回收站的）订单
     * @param order
     * @return
     */
    @Override
    public long totalOrderList(Order order) {
        List<String> list = new ArrayList<>();
        list.add("-1");
        OrderExample orderExample = new OrderExample();
        orderExample.createCriteria().andUserIdEqualTo(order.getUserId()).andOrderStatusNotIn(list);
        return orderMapper.countByExample(orderExample);
    }

    /**
     * 根据订单状态查询待付款、待发货、已收货、待评价、已删除（到回收站）订单
     * @param order
     * @return
     */
    @Override
    public List<Order> getOrderByStatus(Order order) {
        List<Order> orderList = orderMapper.getOrderByStatus(order);
        if (orderList.size() > 0) {
            return orderList;
        }
        return null;
    }

    /**
     * 统计不同状态的订单数量
     * @param order
     * @return
     */
    @Override
    public int statusOrderList(Order order) {
        return orderMapper.statusOrderList(order);
    }

    /**
     * 修改订单状态为已支付、已发货、确认收货、已评价订单，包括逻辑删除订单到回收站
     * @param order
     * @return
     */
    @Override
    public boolean updateOrderStatus(Order order) {
        Integer score = order.getGoodsScores();
        switch (score) {
        }
        return orderMapper.updateByPrimaryKeySelective(order) == 1 ? true : false;
    }

    @Override
    public boolean delOrder(Long orderId) {
        return orderMapper.deleteByPrimaryKey(orderId) == 1 ? true : false;
    }

    @Override
    public List<Order> getOrdersByLike(Order order) {
        return orderMapper.getOrdersByLike(order);
    }

    @Override
    public Integer totalByLike(Order order) {
        return orderMapper.totalByLike(order);
    }

}
