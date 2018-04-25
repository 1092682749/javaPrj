package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Admin;

public interface AdminMapper extends Mapper<Admin> {
    public Admin findAdminByAccount(Admin admin);
}