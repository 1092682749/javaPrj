package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Permissions;
import com.qy.service.PermissionsService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/permissions")
public class PermissionsController {
    @Resource
    private PermissionsService permissionsService;

    @PostMapping("/add")
    public Result add(@RequestBody Permissions permissions) {
        permissionsService.save(permissions);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        permissionsService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Permissions permissions) {
        permissionsService.update(permissions);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Permissions permissions = permissionsService.findById(id);
        return ResultGenerator.successResult(permissions);
    }

    @GetMapping("/list")
    public Result list(PageBean<Permissions> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Permissions> list = permissionsService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
