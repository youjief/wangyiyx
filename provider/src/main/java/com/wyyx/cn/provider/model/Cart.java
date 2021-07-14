package com.wyyx.cn.provider.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Cart implements Serializable {
    private static final long serialVersionUID = 3910457040530396610L;


    private Long cartId;

    private Long userId;

    private Long goodsId;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private String goodsDetail;

    private BigDecimal goodsPrice;

    private Integer goodsNumbers;

}