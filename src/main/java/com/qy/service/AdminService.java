package com.qy.service;
import com.qy.model.Admin;
import com.qy.base.core.Service;

import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
public interface AdminService extends Service<Admin> {
    public Admin findAdminByAccount(Admin admin);
    public Map<String,Object> verify(Admin admin);
}
