package com.qy.model;

import javax.persistence.*;

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 排序规则
     */
    private String sort;

    /**
     * 品类名称
     */
    private String c_name;

    /**
     * 品类描述
     */
    private String c_descripe;

    /**
     * 商品状态0未上架 1上架
     */
    private Integer c_state;

    /**
     * 添加时间
     */
    private String c_add_time;

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
     * 获取排序规则
     *
     * @return sort - 排序规则
     */
    public String getSort() {
        return sort;
    }

    /**
     * 设置排序规则
     *
     * @param sort 排序规则
     */
    public void setSort(String sort) {
        this.sort = sort;
    }

    /**
     * 获取品类名称
     *
     * @return c_name - 品类名称
     */
    public String getC_name() {
        return c_name;
    }

    /**
     * 设置品类名称
     *
     * @param c_name 品类名称
     */
    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    /**
     * 获取品类描述
     *
     * @return c_descripe - 品类描述
     */
    public String getC_descripe() {
        return c_descripe;
    }

    /**
     * 设置品类描述
     *
     * @param c_descripe 品类描述
     */
    public void setC_descripe(String c_descripe) {
        this.c_descripe = c_descripe;
    }

    /**
     * 获取商品状态0未上架 1上架
     *
     * @return c_state - 商品状态0未上架 1上架
     */
    public Integer getC_state() {
        return c_state;
    }

    /**
     * 设置商品状态0未上架 1上架
     *
     * @param c_state 商品状态0未上架 1上架
     */
    public void setC_state(Integer c_state) {
        this.c_state = c_state;
    }

    /**
     * 获取添加时间
     *
     * @return c_add_time - 添加时间
     */
    public String getC_add_time() {
        return c_add_time;
    }

    /**
     * 设置添加时间
     *
     * @param c_add_time 添加时间
     */
    public void setC_add_time(String c_add_time) {
        this.c_add_time = c_add_time;
    }
}