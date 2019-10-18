package com.wyyx.cn.consumer.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by GY on 2019/10/18 15:08
 */
public class PriceVo implements Serializable {
    @ApiModelProperty(value = "用户等级",required = true)
    private Integer userLevel;

    @ApiModelProperty(value = "用户积分",required = true)
    private Integer userScores;

    @ApiModelProperty(value = "用户是否为超级会员",required = true)
    private int vip;

    @ApiModelProperty(value = "购买商品数量",required = true)
    private int goodsCount;

    @ApiModelProperty(value = "商品单价",required = true)
    private double goodsPrice;

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public Integer getUserScores() {
        return userScores;
    }

    public void setUserScores(Integer userScores) {
        this.userScores = userScores;
    }

    public int getVip() {
        return vip;
    }

    public void setVip(int vip) {
        this.vip = vip;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }
}
