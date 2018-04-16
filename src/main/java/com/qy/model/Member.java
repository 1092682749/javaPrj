package com.qy.model;

import javax.persistence.*;

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 头像图片
     */
    private String header_img;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 注册时间
     */
    private String add_time;

    /**
     * 微信id
     */
    private String open_id;

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
     * 获取头像图片
     *
     * @return header_img - 头像图片
     */
    public String getHeader_img() {
        return header_img;
    }

    /**
     * 设置头像图片
     *
     * @param header_img 头像图片
     */
    public void setHeader_img(String header_img) {
        this.header_img = header_img;
    }

    /**
     * 获取手机号码
     *
     * @return phone - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取注册时间
     *
     * @return add_time - 注册时间
     */
    public String getAdd_time() {
        return add_time;
    }

    /**
     * 设置注册时间
     *
     * @param add_time 注册时间
     */
    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    /**
     * 获取微信id
     *
     * @return open_id - 微信id
     */
    public String getOpen_id() {
        return open_id;
    }

    /**
     * 设置微信id
     *
     * @param open_id 微信id
     */
    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
}