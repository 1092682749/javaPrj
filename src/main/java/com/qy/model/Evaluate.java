package com.qy.model;

import javax.persistence.*;

public class Evaluate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品id
     */
    private Integer goods_id;

    /**
     * 客户Id
     */
    private Integer member_id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论时间
     */
    private String add_time;

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
     * 获取客户Id
     *
     * @return member_id - 客户Id
     */
    public Integer getMember_id() {
        return member_id;
    }

    /**
     * 设置客户Id
     *
     * @param member_id 客户Id
     */
    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    /**
     * 获取评论内容
     *
     * @return content - 评论内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容
     *
     * @param content 评论内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取评论时间
     *
     * @return add_time - 评论时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置评论时间
     *
     * @param add_time 评论时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}