package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.Cart;
import com.wyyx.cn.provider.model.Goods;
import com.wyyx.cn.provider.model.Order;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GY on 2019/10/18 10:44
 */
public interface GoodsService {

    List<Goods> findGodds(int goodsId);

    //查用户等级
    int findLevel(Integer userLevel);

    //查用户是否为超级会员
    int findVip(int vip);

    //查询总价
    double findSum(double goodsSumprice);

    List<Cart> findOrder(Cart cart);

    int insterOrder(Order order);





}
