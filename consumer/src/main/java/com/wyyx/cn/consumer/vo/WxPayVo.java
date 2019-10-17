package com.wyyx.cn.consumer.vo;

import lombok.Data;

/**
 * Created by jt on 2019/10/17 19:52
 */
@Data
public class WxPayVo {
    private String body;
    private String out_trade_no;
    private int total_fee;
}
