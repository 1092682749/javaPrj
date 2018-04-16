package com.qy.service.impl;

import com.qy.dao.RolePermissionsMapper;
import com.qy.model.RolePermissions;
import com.qy.service.RolePermissionsService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class RolePermissionsServiceImpl extends AbstractService<RolePermissions> implements RolePermissionsService {
    @Resource
    private RolePermissionsMapper rolePermissionsMapper;

}
