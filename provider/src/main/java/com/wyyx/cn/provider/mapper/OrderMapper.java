package com.wyyx.cn.provider.mapper;

import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.model.OrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    //---------------------------------

    List<Order> getOrderList(Order order);

    int totalOrderList();

    List<Order> getOrderByStatus(@Param("orderStatus") int orderStatus,@Param("startItem") int startItem, @Param("pageSize") int pageSize);

    int statusOrderList(int orderStatus);

    int updateOrderStatus(Order order);

    int delOrder(Order order);

    List<Order> getOrderList2(Order order,@Param("startItem") int startItem, @Param("pageSize") int pageSize);
}