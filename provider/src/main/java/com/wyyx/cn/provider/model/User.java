package com.wyyx.cn.provider.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private static final long serialVersionUID = 5411760744065952413L;
    private Long userId;

    private String userPhone;

    private Integer isDelete;

    private String userName;

    private String userPassword;

    private Integer userLevel;

    private Date createTime;

    private Date updateTime;

    private String openid;

    private String nickname;

    private String language;

    private String city;

    private String province;

    private String country;

    private String headimgurl;

    private String privilege;

    private String sex;

    private Integer expValue;

    private Integer userScores;

    private String ipAddress;

    private String vip;

    private String birthday;

    private Integer birthIsChange;

    private String userAddr;

}