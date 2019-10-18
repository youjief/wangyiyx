package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.mapper.GoodsMapper;
import com.wyyx.cn.provider.mapper.OrderMapper;
import com.wyyx.cn.provider.mapper.UserMapper;
import com.wyyx.cn.provider.model.Goods;
import com.wyyx.cn.provider.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
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

    //查用户积分
    @Override
    public int findScores(Integer userScores) {
        return userMapper.findScores(userScores);
    }

    //查用户是否为超级会员
    @Override
    public int findVip(int vip) {
        return userMapper.findVip(vip);
    }

    //查询用户购买数量
    @Override
    public int findCount(int goodsCount) {
        return orderMapper.findCount(goodsCount);
    }

    //查询商品单价
    @Override
    public double findPrice(double goodsPrice) {
        return goodsMapper.findPrice(goodsPrice);
    }
}
