package com.qy.model;

import javax.persistence.*;

public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名
     */
    private String role_name;

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
     * 获取角色名
     *
     * @return role_name - 角色名
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置角色名
     *
     * @param role_name 角色名
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}