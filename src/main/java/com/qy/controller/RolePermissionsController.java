package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.RolePermissions;
import com.qy.service.RolePermissionsService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/role/permissions")
public class RolePermissionsController {
    @Resource
    private RolePermissionsService rolePermissionsService;

    @PostMapping("/add")
    public Result add(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.save(rolePermissions);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        rolePermissionsService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody RolePermissions rolePermissions) {
        rolePermissionsService.update(rolePermissions);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        RolePermissions rolePermissions = rolePermissionsService.findById(id);
        return ResultGenerator.successResult(rolePermissions);
    }

    @GetMapping("/list")
    public Result list(PageBean<RolePermissions> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<RolePermissions> list = rolePermissionsService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
