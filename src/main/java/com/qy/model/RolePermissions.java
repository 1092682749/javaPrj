package com.qy.model;

import javax.persistence.*;

@Table(name = "role_permissions")
public class RolePermissions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户id
     */
    private String role_id;

    /**
     * 角色id
     */
    private String permissions_id;

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
     * @return role_id - 用户id
     */
    public String getRole_id() {
        return role_id;
    }

    /**
     * 设置用户id
     *
     * @param role_id 用户id
     */
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取角色id
     *
     * @return permissions_id - 角色id
     */
    public String getPermissions_id() {
        return permissions_id;
    }

    /**
     * 设置角色id
     *
     * @param permissions_id 角色id
     */
    public void setPermissions_id(String permissions_id) {
        this.permissions_id = permissions_id;
    }
}