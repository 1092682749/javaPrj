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
    private Integer role_id;

    /**
     * 角色id
     */
    private Integer permissions_id;

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
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置用户id
     *
     * @param role_id 用户id
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取角色id
     *
     * @return permissions_id - 角色id
     */
    public Integer getPermissions_id() {
        return permissions_id;
    }

    /**
     * 设置角色id
     *
     * @param permissions_id 角色id
     */
    public void setPermissions_id(Integer permissions_id) {
        this.permissions_id = permissions_id;
    }
}