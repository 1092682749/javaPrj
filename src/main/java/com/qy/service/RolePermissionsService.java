package com.qy.service;
import com.qy.model.Permissions;
import com.qy.model.RolePermissions;
import com.qy.base.core.Service;

import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
public interface RolePermissionsService extends Service<RolePermissions> {
        public List<RolePermissions> findPermissionByRoleId(Integer id);
}
