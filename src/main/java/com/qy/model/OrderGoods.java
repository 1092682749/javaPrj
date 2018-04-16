package com.qy.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "order_goods")
public class OrderGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单编号
     */
    private String order_id;

    /**
     * 商品封面
     */
    private String goods_img;

    /**
     * 商品名称
     */
    private String goods_name;

    /**
     * 商品价格
     */
    private BigDecimal goods_price;

    /**
     * 商品直降金额
     */
    private BigDecimal reduce_price;

    /**
     * 商品重量
     */
    private Long goods_weight;

    /**
     * 商品单位
     */
    private String goods_unit;

    /**
     * 商品数量
     */
    private String goods_num;

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
     * 获取订单编号
     *
     * @return order_id - 订单编号
     */
    public String getOrder_id() {
        return order_id;
    }

    /**
     * 设置订单编号
     *
     * @param order_id 订单编号
     */
    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    /**
     * 获取商品封面
     *
     * @return goods_img - 商品封面
     */
    public String getGoods_img() {
        return goods_img;
    }

    /**
     * 设置商品封面
     *
     * @param goods_img 商品封面
     */
    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
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
     * 获取商品直降金额
     *
     * @return reduce_price - 商品直降金额
     */
    public BigDecimal getReduce_price() {
        return reduce_price;
    }

    /**
     * 设置商品直降金额
     *
     * @param reduce_price 商品直降金额
     */
    public void setReduce_price(BigDecimal reduce_price) {
        this.reduce_price = reduce_price;
    }

    /**
     * 获取商品重量
     *
     * @return goods_weight - 商品重量
     */
    public Long getGoods_weight() {
        return goods_weight;
    }

    /**
     * 设置商品重量
     *
     * @param goods_weight 商品重量
     */
    public void setGoods_weight(Long goods_weight) {
        this.goods_weight = goods_weight;
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
     * 获取商品数量
     *
     * @return goods_num - 商品数量
     */
    public String getGoods_num() {
        return goods_num;
    }

    /**
     * 设置商品数量
     *
     * @param goods_num 商品数量
     */
    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }
}