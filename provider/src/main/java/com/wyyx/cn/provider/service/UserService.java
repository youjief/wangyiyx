package com.wyyx.cn.provider.service;

import com.wyyx.cn.provider.model.User;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: 91917
 * Date: 2019/10/17
 * Time: 14:16
 * Description: No Description
 */
public interface UserService {
    //订单完成后给该用户增加商品价格百分之十的积分
    int addUser_scores(User user, BigDecimal goods_price);

    //登录加经验
    int loginAddExp(User user);

    //购买商品加经验and积分
    int buyAddExp(User user, BigDecimal goods_price);

    //根据经验值来修改等级
    int changeAndReturnLevel(User user);


}
