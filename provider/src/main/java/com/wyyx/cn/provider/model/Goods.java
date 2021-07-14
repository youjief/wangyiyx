package com.wyyx.cn.provider.model;


import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Goods implements Serializable {
    private static final long serialVersionUID = -8776980716829420298L;

    private Integer goodsId;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private Integer goodsKind;

    private BigDecimal goodsPrice;

    private String goodsStock;

    private String goodsPraise;

    private String goodsIsSeckill;

    private String goodsSales;

}