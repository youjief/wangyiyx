package com.wyyx.cn.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wyyx.cn.consumer.untils.result.ReturnResult;
import com.wyyx.cn.consumer.untils.result.ReturnResultUtils;
import com.wyyx.cn.consumer.vo.PriceVo;
import com.wyyx.cn.provider.service.GoodsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


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
    public ReturnResult findGoodId(@ApiParam(value = "商品id",required = true) @RequestParam(value = "goodsId")Integer goodsId){

        return ReturnResultUtils.returnSuccess(goodsService.findGodds(goodsId));

    }
    @ApiOperation("结算")
    @GetMapping(value = "/settelMoney")
    public ReturnResult settelMoney(@Valid PriceVo priceVo){

        double sum = 0;
        double price = goodsService.findPrice(priceVo.getGoodsPrice());
        Integer level = goodsService.findLevel(priceVo.getUserLevel());
        double scores = goodsService.findScores(priceVo.getUserScores());
        int UsersVip = goodsService.findVip(priceVo.getVip());
        double count = goodsService.findCount(priceVo.getGoodsCount());
        if (level==3){
            if (UsersVip==1){
                if (scores>=100){
                    sum = (price * count - 5 - scores % 10)*0.98;
                }else
                    if (scores<100){
                    sum=(price * count - 5)*0.98;
                }
            }else
                if (UsersVip==0){
                if (scores>=100) {
                    sum = price * count - scores%10;
                }else
                if (scores<100){
                    sum = price*count;
                }
            }
        }else
            if (level<3){
            if (scores>=100){
                sum = price*count+10-scores%10;
            }else
                if (scores<100){
                sum=price*count+10;
            }
        }
        return ReturnResultUtils.returnSuccess(sum);
    }

}
