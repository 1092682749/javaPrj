package com.qy.service.impl;

import com.qy.dao.AdminMapper;
import com.qy.model.Admin;
import com.qy.service.AdminService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class AdminServiceImpl extends AbstractService<Admin> implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin findAdminByAccount(Admin admin) {
        return adminMapper.findAdminByAccount(admin);
    }

    @Override
    public Map<String, Object> verify(Admin admin) {
        Map<String,Object> msgMap = new HashMap<>();
        Admin adminFromDB = findAdminByAccount(admin);
        if (adminFromDB != null){
            if (adminFromDB.getPassword().equals(admin.getPassword())){
                msgMap.put("bool",true);
                msgMap.put("msg","验证成功");
                msgMap.put("object",adminFromDB);
            }else {
                msgMap.put("bool",false);
                msgMap.put("msg","密码错误");
                msgMap.put("object",null);
            }
        }else {
            msgMap.put("bool",false);
            msgMap.put("msg","账户不存在");
            msgMap.put("object",null);
        }
        return msgMap;
    }
}
