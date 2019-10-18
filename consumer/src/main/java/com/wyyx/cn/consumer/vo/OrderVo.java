package com.wyyx.cn.consumer.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jt on 2019/10/18 8:47
 */
@Data
public class OrderVo implements Serializable {
    private static final long serialVersionUID = -531803378497541914L;
    //订单状态
    private int orderStatus;
}
