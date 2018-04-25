package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.service.AdminService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/admin")
@SessionAttributes(names = {"admin"})
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin) {
        adminService.save(admin);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        adminService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Admin admin = adminService.findById(id);
        return ResultGenerator.successResult(admin);
    }

    @GetMapping("/list")
    public Result list(PageBean<Admin> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Admin> list = adminService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("admin/login");
        return mav;
    }
    @RequestMapping("/verify")
    @ResponseBody
    public Map<String,Object> verify(Admin admin){
        Map<String,Object> map = new HashMap<>();
        map.put("bool",false);
        map.put("msg","登陆失败!");
        return map;
    }
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("admin/index");
    }
}
