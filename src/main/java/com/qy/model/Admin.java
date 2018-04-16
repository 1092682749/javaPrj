package com.qy.model;

import javax.persistence.*;

public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 帐户
     */
    private String account;

    /**
     * 用户名
     */
    private String name;

    /**
     * 角色ID
     */
    private String role_id;

    /**
     * 密码
     */
    private String password;

    /**
     * 添加时间
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
     * 获取帐户
     *
     * @return account - 帐户
     */
    public String getAccount() {
        return account;
    }

    /**
     * 设置帐户
     *
     * @param account 帐户
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 获取用户名
     *
     * @return name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name 用户名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色ID
     *
     * @return role_id - 角色ID
     */
    public String getRole_id() {
        return role_id;
    }

    /**
     * 设置角色ID
     *
     * @param role_id 角色ID
     */
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
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
}