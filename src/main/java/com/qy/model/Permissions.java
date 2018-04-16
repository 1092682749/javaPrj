package com.qy.model;

import javax.persistence.*;

public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 权限名称
     */
    private String title;

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
     * 获取权限名称
     *
     * @return title - 权限名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置权限名称
     *
     * @param title 权限名称
     */
    public void setTitle(String title) {
        this.title = title;
    }
}