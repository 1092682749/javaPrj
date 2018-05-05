package com.qy.controller;
import com.github.pagehelper.PageInfo;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.model.Banner;
import com.qy.model.Permissions;
import com.qy.model.RolePermissions;
import com.qy.service.BannerService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import com.qy.service.PermissionsService;
import com.qy.service.RolePermissionsService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;
    @Resource
    private PermissionsService permissionsService;
    @Resource
    private RolePermissionsService rolePermissionsService;

    @PostMapping("/add")
    public Result add(@RequestBody Banner banner) {
        bannerService.save(banner);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        bannerService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Banner banner) {
        bannerService.update(banner);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Banner banner = bannerService.findById(id);
        return ResultGenerator.successResult(banner);
    }

    @GetMapping("/list")
    public Result list(PageBean<Banner> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Banner> list = bannerService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin user,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        ModelAndView mav = new ModelAndView("admin/index");
        PageHelper.startPage(pn,5);
        List<Banner> bannerList = bannerService.findAll();
        PageInfo pageInfo = new PageInfo(bannerList,5);
        mav.addObject("pageInfo",pageInfo);
        mav.addObject("user",user);
        return mav;
    }
    @RequestMapping("/permissionCheck")
    public @ResponseBody boolean permissionCheck(@SessionAttribute Admin user,String operation){
        List<RolePermissions> permissionsList = rolePermissionsService.findPermissionByRoleId(user.getId());
        for (RolePermissions permissions : permissionsList){
            if (permissions.getPermissions_id() == Integer.parseInt(operation)){
                return true;
            }
        }
        return false;
    }
    @RequestMapping("/to")
    public ModelAndView to(){
        return new ModelAndView("admin/testFile");
    }
    @RequestMapping("/upload")
    public void upload(HttpServletRequest request){
        MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest) request;
        MultipartFile file = mhsr.getFile("pic");
        System.out.println(file);
    }
}
