package com.qy.service.impl;

import com.qy.dao.PermissionsMapper;
import com.qy.model.Permissions;
import com.qy.service.PermissionsService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class PermissionsServiceImpl extends AbstractService<Permissions> implements PermissionsService {
    @Resource
    private PermissionsMapper permissionsMapper;

}
