package com.wyyx.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyyx.cn.consumer.config.custom.CurrentUser;
import com.wyyx.cn.consumer.config.custom.LoginRequired;
import com.wyyx.cn.consumer.contants.OrderContants;
import com.wyyx.cn.consumer.untils.result.Pages;
import com.wyyx.cn.consumer.untils.result.ReturnResult;
import com.wyyx.cn.consumer.untils.result.ReturnResultUtils;
import com.wyyx.cn.consumer.vo.OrderVo;
import com.wyyx.cn.consumer.vo.PageVo;
import com.wyyx.cn.consumer.vo.UserVo;
import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.model.User;
import com.wyyx.cn.provider.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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

    @ApiOperation("全部订单")
    @GetMapping(value = "/getOrders")
    public ReturnResult<Pages> getOrders(OrderVo orderVo) {

        Order order = new Order();
        BeanUtils.copyProperties(orderVo,order);
        order.setStartItem(orderVo.getPageVo().getStartItem());
        order.setPageSize(orderVo.getPageVo().getPageSize());

        long totalOrderList = orderService.totalOrderList(order);
        if (totalOrderList > 0) {
            List<Order> orders = orderService.getOrders(order);

            Pages pages = new Pages();
            pages.setCurrentPage(orderVo.getPageVo().getCurPage());
            pages.setPagesize(orderVo.getPageVo().getPageSize());
            pages.setCurrList(orders);
            pages.setTotalCount(totalOrderList);

            return ReturnResultUtils.returnSuccess(pages);
        }
        return ReturnResultUtils.returnFail(OrderContants.NO_ORDER_CODE, OrderContants.NO_ORDER_MSG);
    }

    @ApiOperation("根据订单状态查询")
    @GetMapping(value = "/getOrderByStatus")
    public ReturnResult getOrderByStatus(@Valid PageVo pageVo,
                                         @Valid OrderVo orderVo) {
        int statusOrderList = orderService.statusOrderList(orderVo.getOrderStatus());
        if (statusOrderList > 0) {
            List<Order> orderByStatus = orderService.getOrderByStatus(orderVo.getOrderStatus(), pageVo.getStartItem(), pageVo.getPageSize());
            if (orderByStatus.size() > 0) {
                Pages pages = new Pages();
                pages.setCurrentPage(pageVo.getCurPage());
                pages.setPagesize(pageVo.getPageSize());
                pages.setCurrList(orderByStatus);
                pages.setTotalCount(statusOrderList);
                return ReturnResultUtils.returnSuccess(pages);
            }
        }
        return ReturnResultUtils.returnFail(OrderContants.NO_ORDER_CODE, OrderContants.NO_ORDER_MSG);
    }

}
