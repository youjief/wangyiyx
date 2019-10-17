package com.wyyx.cn.provider.model;

<<<<<<< HEAD
import lombok.Data;

=======
>>>>>>> 9fd4455be152eb34c791953713019e3acc1ac1a5
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

<<<<<<< HEAD
@Data
public class Order implements Serializable {

    private static final long serialVersionUID = -5726744053711926679L;

=======
public class Order implements Serializable {
>>>>>>> 9fd4455be152eb34c791953713019e3acc1ac1a5
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