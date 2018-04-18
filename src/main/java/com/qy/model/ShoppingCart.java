package com.qy.model;

import javax.persistence.*;

@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 购物车添加时间
     */
    private String s_add_time;

    /**
     * 用户id
     */
    private Integer s_member_id;

    /**
     * 商品id
     */
    private Integer goods_id;

    /**
     * 商品数量
     */
    private Integer goods_num;

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "ShoppingCart{" +
                "id=" + id +
                ", s_add_time='" + s_add_time + '\'' +
                ", s_member_id=" + s_member_id +
                ", goods_id=" + goods_id +
                ", goods_num=" + goods_num +
                '}';
    }

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
     * 获取购物车添加时间
     *
     * @return s_add_time - 购物车添加时间
     */
    public String getS_add_time() {
        return s_add_time;
    }

    /**
     * 设置购物车添加时间
     *
     * @param s_add_time 购物车添加时间
     */
    public void setS_add_time(String s_add_time) {
        this.s_add_time = s_add_time;
    }

    /**
     * 获取用户id
     *
     * @return s_member_id - 用户id
     */
    public Integer getS_member_id() {
        return s_member_id;
    }

    /**
     * 设置用户id
     *
     * @param s_member_id 用户id
     */
    public void setS_member_id(Integer s_member_id) {
        this.s_member_id = s_member_id;
    }

    /**
     * 获取商品id
     *
     * @return goods_id - 商品id
     */
    public Integer getGoods_id() {
        return goods_id;
    }

    /**
     * 设置商品id
     *
     * @param goods_id 商品id
     */
    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * 获取商品数量
     *
     * @return goods_num - 商品数量
     */
    public Integer getGoods_num() {
        return goods_num;
    }

    /**
     * 设置商品数量
     *
     * @param goods_num 商品数量
     */
    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }
}