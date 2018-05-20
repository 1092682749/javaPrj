package com.qy.model;

import javax.persistence.*;

@Table(name = "index_banner")
public class IndexBanner {
    /**
     * 首页轮播id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 图片路径
     */
    private String i_src;

    /**
     * 1活动，0商品
     */
    private Integer type;

    /**
     * 商品id
     */
    private Integer goods_id;

    /**
     * 创建时间
     */
    private String add_time;

    /**
     * 排序
     */
    private String sort;

    /**
     * 1上架，0未上架
     */
    private Integer state = new Integer(0);

    /**
     * 获取首页轮播id
     *
     * @return id - 首页轮播id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置首页轮播id
     *
     * @param id 首页轮播id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取图片路径
     *
     * @return i_src - 图片路径
     */
    public String getI_src() {
        return i_src;
    }

    /**
     * 设置图片路径
     *
     * @param i_src 图片路径
     */
    public void setI_src(String i_src) {
        this.i_src = i_src;
    }

    /**
     * 获取1活动，0商品
     *
     * @return type - 1活动，0商品
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1活动，0商品
     *
     * @param type 1活动，0商品
     */
    public void setType(Integer type) {
        this.type = type;
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
     * 获取创建时间
     *
     * @return add_time - 创建时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置创建时间
     *
     * @param add_time 创建时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
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
     * 获取1上架，0未上架
     *
     * @return state - 1上架，0未上架
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1上架，0未上架
     *
     * @param state 1上架，0未上架
     */
    public void setState(Integer state) {
        this.state = state;
    }
}