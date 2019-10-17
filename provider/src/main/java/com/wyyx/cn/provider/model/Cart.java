package com.wyyx.cn.provider.model;

<<<<<<< HEAD
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Cart implements Serializable {
    private static final long serialVersionUID = 3910457040530396610L;
=======
import java.io.Serializable;
import java.math.BigDecimal;

public class Cart implements Serializable {
>>>>>>> 9fd4455be152eb34c791953713019e3acc1ac1a5
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