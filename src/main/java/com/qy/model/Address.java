package com.qy.model;

import javax.persistence.*;

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    private String member_id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 邮编
     */
    private String postal_code;

    /**
     * 添加时间
     */
    private String add_time;

    /**
     * 是否默认地址 0否 1是
     */
    private Integer is_default;

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
     * 获取用户id
     *
     * @return member_id - 用户id
     */
    public String getMember_id() {
        return member_id;
    }

    /**
     * 设置用户id
     *
     * @param member_id 用户id
     */
    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    /**
     * 获取姓名
     *
     * @return name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取电话号码
     *
     * @return phone - 电话号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话号码
     *
     * @param phone 电话号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取邮编
     *
     * @return postal_code - 邮编
     */
    public String getPostal_code() {
        return postal_code;
    }

    /**
     * 设置邮编
     *
     * @param postal_code 邮编
     */
    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
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
     * 获取是否默认地址 0否 1是
     *
     * @return is_default - 是否默认地址 0否 1是
     */
    public Integer getIs_default() {
        return is_default;
    }

    /**
     * 设置是否默认地址 0否 1是
     *
     * @param is_default 是否默认地址 0否 1是
     */
    public void setIs_default(Integer is_default) {
        this.is_default = is_default;
    }
}