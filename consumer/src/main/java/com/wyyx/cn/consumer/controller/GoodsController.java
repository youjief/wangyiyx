package com.wyyx.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyyx.cn.consumer.config.custom.CurrentUser;
import com.wyyx.cn.consumer.config.custom.LoginRequired;
import com.wyyx.cn.consumer.untils.result.ReturnResult;
import com.wyyx.cn.consumer.untils.result.ReturnResultUtils;
import com.wyyx.cn.consumer.vo.UserVo;
import com.wyyx.cn.provider.model.User;
import com.wyyx.cn.provider.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * Created by GY on 2019/10/18 11:06
 */
@Api(tags = "展示商品")
@RestController
@RequestMapping(value = "/GoodsController")
public class GoodsController {

    @Reference
    private GoodsService goodsService;

    @ApiOperation("商品")
    @GetMapping(value = "/findGoodId")
    public ReturnResult findGoodId(@ApiParam(value = "商品id", required = true) @RequestParam(value = "goodsId") Integer goodsId) {

        return ReturnResultUtils.returnSuccess(goodsService.findGodds(goodsId));

    }

    @LoginRequired
    @ApiOperation("结算")
    @GetMapping(value = "/settelMoney")
    public ReturnResult settelMoney(@ApiParam(value = "用户名登录", required = false) @RequestParam(value = "userName") Long userId,
                                    @CurrentUser UserVo userVo) {
        User users = new User();
        users.getUserId();
        double allSum = 0;
        double sum = goodsService.findSum(userVo.getGoodsSumprice());
        int level = goodsService.findLevel(userVo.getUserLevel());
        int vip = goodsService.findVip(userVo.getVip());
        if (level == 4) {
            if (vip == 1) {
                allSum = sum - 5;
            }
            if (vip == 0) {
                allSum = sum;
            }
        }
        if (level < 4) {
            allSum = sum + 10;
        }
        return ReturnResultUtils.returnSuccess(allSum);
    }
}