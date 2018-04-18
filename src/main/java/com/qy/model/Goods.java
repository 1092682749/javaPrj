package com.qy.model;

import java.math.BigDecimal;
import javax.persistence.*;

public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品图片
     */
    private String goods_img;

    /**
     * 排序
     */
    private String g_sort;

    /**
     * 商品所属品类ID
     */
    private Integer category_id;

    /**
     * 商品名称
     */
    private String goods_name;

    /**
     * 商品价格
     */
    private BigDecimal goods_price;

    /**
     * 直降金额 降到多少钱
     */
    private BigDecimal goods_reduce;

    /**
     * 最低销售重量
     */
    private Integer min_sale_weight;

    /**
     * 库存量
     */
    private Integer stock_num;

    /**
     * 商品单位
     */
    private String goods_unit;

    /**
     * 添加时间
     */
    private String g_add_time;

    /**
     * 是否上架
     */
    private Integer g_state;

    /**
     * 详情
     */
    private String detail;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品图片
     *
     * @return goods_img - 商品图片
     */
    public String getGoods_img() {
        return goods_img;
    }

    /**
     * 设置商品图片
     *
     * @param goods_img 商品图片
     */
    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }

    /**
     * 获取排序
     *
     * @return g_sort - 排序
     */
    public String getG_sort() {
        return g_sort;
    }

    /**
     * 设置排序
     *
     * @param g_sort 排序
     */
    public void setG_sort(String g_sort) {
        this.g_sort = g_sort;
    }

    /**
     * 获取商品所属品类ID
     *
     * @return category_id - 商品所属品类ID
     */
    public Integer getCategory_id() {
        return category_id;
    }

    /**
     * 设置商品所属品类ID
     *
     * @param category_id 商品所属品类ID
     */
    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }

    /**
     * 获取商品名称
     *
     * @return goods_name - 商品名称
     */
    public String getGoods_name() {
        return goods_name;
    }

    /**
     * 设置商品名称
     *
     * @param goods_name 商品名称
     */
    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    /**
     * 获取商品价格
     *
     * @return goods_price - 商品价格
     */
    public BigDecimal getGoods_price() {
        return goods_price;
    }

    /**
     * 设置商品价格
     *
     * @param goods_price 商品价格
     */
    public void setGoods_price(BigDecimal goods_price) {
        this.goods_price = goods_price;
    }

    /**
     * 获取直降金额 降到多少钱
     *
     * @return goods_reduce - 直降金额 降到多少钱
     */
    public BigDecimal getGoods_reduce() {
        return goods_reduce;
    }

    /**
     * 设置直降金额 降到多少钱
     *
     * @param goods_reduce 直降金额 降到多少钱
     */
    public void setGoods_reduce(BigDecimal goods_reduce) {
        this.goods_reduce = goods_reduce;
    }

    /**
     * 获取最低销售重量
     *
     * @return min_sale_weight - 最低销售重量
     */
    public Integer getMin_sale_weight() {
        return min_sale_weight;
    }

    /**
     * 设置最低销售重量
     *
     * @param min_sale_weight 最低销售重量
     */
    public void setMin_sale_weight(Integer min_sale_weight) {
        this.min_sale_weight = min_sale_weight;
    }

    /**
     * 获取库存量
     *
     * @return stock_num - 库存量
     */
    public Integer getStock_num() {
        return stock_num;
    }

    /**
     * 设置库存量
     *
     * @param stock_num 库存量
     */
    public void setStock_num(Integer stock_num) {
        this.stock_num = stock_num;
    }

    /**
     * 获取商品单位
     *
     * @return goods_unit - 商品单位
     */
    public String getGoods_unit() {
        return goods_unit;
    }

    /**
     * 设置商品单位
     *
     * @param goods_unit 商品单位
     */
    public void setGoods_unit(String goods_unit) {
        this.goods_unit = goods_unit;
    }

    /**
     * 获取添加时间
     *
     * @return g_add_time - 添加时间
     */
    public String getG_add_time() {
        return g_add_time;
    }

    /**
     * 设置添加时间
     *
     * @param g_add_time 添加时间
     */
    public void setG_add_time(String g_add_time) {
        this.g_add_time = g_add_time;
    }

    /**
     * 获取是否上架
     *
     * @return g_state - 是否上架
     */
    public Integer getG_state() {
        return g_state;
    }

    /**
     * 设置是否上架
     *
     * @param g_state 是否上架
     */
    public void setG_state(Integer g_state) {
        this.g_state = g_state;
    }

    /**
     * 获取详情
     *
     * @return detail - 详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置详情
     *
     * @param detail 详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }
}