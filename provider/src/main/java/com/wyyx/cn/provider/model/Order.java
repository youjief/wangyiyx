package com.wyyx.cn.provider.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -5726744053711926679L;

    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private String deliveryAddr;

    private String goodsName;

    private String goodsCount;

    private BigDecimal goodsPrice;

    private String orderChannel;

    private String orderStatus;

    private Date createTime;

    private Date payTime;

    private String goodsFreight;

    private String goodsScores;

}