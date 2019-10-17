package com.wyyx.cn.provider.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Goods implements Serializable {
    private Integer goodsId;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private Integer goodsKind;

    private BigDecimal goodsPrice;

    private String goodsStock;

    private String goodsPraise;

    private String goodsIsSeckill;

    private String goodsSales;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsTitle() {
        return goodsTitle;
    }

    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Integer getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(Integer goodsKind) {
        this.goodsKind = goodsKind;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(String goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getGoodsPraise() {
        return goodsPraise;
    }

    public void setGoodsPraise(String goodsPraise) {
        this.goodsPraise = goodsPraise;
    }

    public String getGoodsIsSeckill() {
        return goodsIsSeckill;
    }

    public void setGoodsIsSeckill(String goodsIsSeckill) {
        this.goodsIsSeckill = goodsIsSeckill;
    }

    public String getGoodsSales() {
        return goodsSales;
    }

    public void setGoodsSales(String goodsSales) {
        this.goodsSales = goodsSales;
    }
}