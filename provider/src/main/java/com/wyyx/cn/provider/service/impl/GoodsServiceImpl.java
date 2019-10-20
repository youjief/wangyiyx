package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.mapper.CartMapper;
import com.wyyx.cn.provider.mapper.GoodsMapper;
import com.wyyx.cn.provider.mapper.OrderMapper;
import com.wyyx.cn.provider.mapper.UserMapper;
import com.wyyx.cn.provider.model.Cart;
import com.wyyx.cn.provider.model.Goods;
import com.wyyx.cn.provider.model.Order;
import com.wyyx.cn.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by GY on 2019/10/18 10:44
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Goods> findGodds(int goodsId) {
        return goodsMapper.findGoods(goodsId);
    }

    //查用户等级
    @Override
    public int findLevel(Integer userLevel) {
        return userMapper.findLevel(userLevel);
    }

    //查用户是否为超级会员
    @Override
    public int findVip(int vip) {
        return userMapper.findVip(vip);
    }

    @Override
    public double findSum(double goodsSumprice) {
        return cartMapper.findSum(goodsSumprice);
    }

    @Override
    public List<Cart> findOrder(Cart cart) {
        return cartMapper.findOrder(cart);
    }

    @Override
    public int insterOrder(Order order) {
        return orderMapper.insert(order);
    }

}
