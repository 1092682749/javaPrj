package com.qy.model;

import javax.persistence.*;

public class Banner {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 封面图
     */
    private String cover_img;

    /**
     * 0代表活动 1代表封面
     */
    private Integer type;

    /**
     * 与商品表关联
     */
    private Integer goods_id;

    /**
     * 排序
     */
    private String sort;

    /**
     * 添加时间
     */
    private String add_time;

    /**
     * 0未上架 1上架
     */
    private Integer state;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取封面图
     *
     * @return cover_img - 封面图
     */
    public String getCover_img() {
        return cover_img;
    }

    /**
     * 设置封面图
     *
     * @param cover_img 封面图
     */
    public void setCover_img(String cover_img) {
        this.cover_img = cover_img;
    }

    /**
     * 获取0代表活动 1代表封面
     *
     * @return type - 0代表活动 1代表封面
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置0代表活动 1代表封面
     *
     * @param type 0代表活动 1代表封面
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取与商品表关联
     *
     * @return goods_id - 与商品表关联
     */
    public Integer getGoods_id() {
        return goods_id;
    }

    /**
     * 设置与商品表关联
     *
     * @param goods_id 与商品表关联
     */
    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置添加时间
     *
     * @param add_time 添加时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    /**
     * 获取0未上架 1上架
     *
     * @return state - 0未上架 1上架
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0未上架 1上架
     *
     * @param state 0未上架 1上架
     */
    public void setState(Integer state) {
        this.state = state;
    }
}