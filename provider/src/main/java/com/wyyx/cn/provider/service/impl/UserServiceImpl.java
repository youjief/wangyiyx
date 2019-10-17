package com.wyyx.cn.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.wyyx.cn.provider.contants.UserContants;
import com.wyyx.cn.provider.mapper.UserMapper;
import com.wyyx.cn.provider.model.User;
import com.wyyx.cn.provider.model.UserExample;
import com.wyyx.cn.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: 91917
 * Date: 2019/10/17
 * Time: 14:17
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser_scores(User user, BigDecimal goods_price) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(user.getUserId());
        int oldScore = userMapper.selectByPrimaryKey(user.getUserId()).getUserScores();
        int newScore = oldScore + goods_price.intValue() / UserContants.PRICE_TO_ADD_SCORE_BASE;
        user.setUserScores(newScore);

        return userMapper.updateByExampleSelective(user, userExample);
    }

    @Override
    public int loginAddExp(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(user.getUserId());
        int oldExpValue = user.getExpValue();
        int newExpValue = oldExpValue + UserContants.LOGIN_TO_ADD_EXP;
        user.setExpValue(newExpValue);
        //增加登录经验
        int returnExp = userMapper.updateByExampleSelective(user, userExample);
        //判断等级
        changeAndReturnLevel(user);
        //增加登录经验
        return returnExp;
    }

    @Override
    public int buyAddExp(User user, BigDecimal goods_price) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(user.getUserId());
        //增加购买经验和价格一半经验值
        int oldExpValue = user.getExpValue();
        int halfOfPriceScore = goods_price.intValue() / UserContants.GOODS_TO_USER_EXP_BASE;
        int newExpValue = oldExpValue + UserContants.SUCCESS_BUY_GOODS_ADD_EXP + halfOfPriceScore;
        user.setExpValue(newExpValue);
        int returnExp = userMapper.updateByExampleSelective(user, userExample);
        //判断等级
        changeAndReturnLevel(user);
        return returnExp;
    }

    @Override
    public int changeAndReturnLevel(User user) {
        int expValue = user.getExpValue();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(user.getUserId());
        if (user.getUserLevel() >= UserContants.USER_LEVEL_3) {
            return UserContants.USER_LEVEL_3;
        } else if (expValue > UserContants.USER_LEVEL_3_EXP) {
            user.setUserLevel(UserContants.USER_LEVEL_3);
            userMapper.updateByExampleSelective(user, userExample);
            return UserContants.USER_LEVEL_3;
        } else if (expValue > UserContants.USER_LEVEL_2_EXP) {
            user.setUserLevel(UserContants.USER_LEVEL_2);
            userMapper.updateByExampleSelective(user, userExample);
            return UserContants.USER_LEVEL_2;
        } else if (expValue > UserContants.USER_LEVEL_1_EXP) {
            user.setUserLevel(UserContants.USER_LEVEL_1);
            userMapper.updateByExampleSelective(user, userExample);
            return UserContants.USER_LEVEL_1;
        } else {
            return UserContants.USER_LEVEL_0;
        }
    }


}
