package com.wyyx.cn.consumer.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by GY on 2019/10/17 14:11
 */

@Data
public class UserVo implements Serializable {


    private Long userId;

    @ApiModelProperty(value = "微信id",required = false)
    private String openid;

    @ApiModelProperty(value = "手机号",required = true)
    private String userPhone;

    @ApiModelProperty(value = "名字",required = true)
    private String userName;

    @ApiModelProperty(value = "密码",required = true)
    private String userPassword;

    @ApiModelProperty(value = "注册时间",required = false)
    private Date createTime;

    @ApiModelProperty(value = "更新时间",required = false)
    private Date updateTime;

    private String privilege;

    @ApiModelProperty(value = "性别",required = true)
    private String sex;

    private String ipAddress;

    private String agree;















}
