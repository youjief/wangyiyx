package com.wyyx.cn.consumer.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by GY on 2019/10/18 11:08
 */
public class GoodsVo implements Serializable {

    @ApiModelProperty(value = "商品id",required = true)
    private Integer goodsId;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }
}
