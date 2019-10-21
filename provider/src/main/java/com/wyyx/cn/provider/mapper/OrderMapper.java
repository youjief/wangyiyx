package com.wyyx.cn.provider.mapper;

import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.model.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    //查询所有订单数量，不包括已删除订单
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //---------------------------------

    //查询全部订单
    List<Order> getOrderList(Order order);

    //查询有状态的订单
    List<Order> getOrderByStatus(Order order);

    //获取有状态订单总数
    int statusOrderList(Order order);

    //修改订单状态
    int updateOrderStatus(Order order);

    //删除订单
    int delOrder(Order order);

    //模糊查询订单
    List<Order> getOrdersByLike(Order order);

    //模糊查询订单总数
    Integer totalByLike(Order order);
}