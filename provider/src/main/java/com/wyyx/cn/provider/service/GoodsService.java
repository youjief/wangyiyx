package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.Goods;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by GY on 2019/10/18 10:44
 */
public interface GoodsService {

    List<Goods> findGodds(int goodsId);

    //查用户等级
    int findLevel(Integer userLevel);

    //查用户积分
    int findScores(Integer userScores);

    //查用户是否为超级会员
    int findVip(int vip);

    //查询用户购买数量
    int findCount(int goodsCount);

    double findPrice(double goodsPrice);
}
