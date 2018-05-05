package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Permissions;
import com.qy.model.RolePermissions;

import java.util.List;

public interface RolePermissionsMapper extends Mapper<RolePermissions> {
    public List<RolePermissions> findPermissionByRoleId(Integer id);
}