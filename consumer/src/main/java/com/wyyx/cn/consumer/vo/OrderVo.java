package com.wyyx.cn.consumer.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by jt on 2019/10/18 8:47
 */
@Data
public class OrderVo implements Serializable {
    private static final long serialVersionUID = -531803378497541914L;

    private PageVo pageVo;

    private Integer orderId;

    private Integer userId;

    private Integer goodsId;

    private String deliveryAddr;

    private String goodsName;

    private String goodsCount;

    private BigDecimal goodsPrice;

    private String orderChannel;

    private Integer orderStatus;

    private Date createTime;

    private Date payTime;

    private String goodsFreight;

    private String goodsScores;
}
