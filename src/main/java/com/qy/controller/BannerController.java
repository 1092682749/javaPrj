package com.qy.controller;
import com.github.pagehelper.PageInfo;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.base.utils.UploadFile;
import com.qy.model.*;
import com.qy.service.*;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    @Resource
    private IndexBannerService indexBannerService;
    @Resource
    private GoodsService goodsService;

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

    //暂时不用此方法
    @RequestMapping("/toManage")
    public ModelAndView toManage(){
        ModelAndView mav = new ModelAndView("admin/index");
        return mav;
    }

    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin user,@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        ModelAndView mav = new ModelAndView("admin/index");
        PageHelper.startPage(pn,5);
        List<IndexBanner> bannerList = indexBannerService.findAll();
        PageInfo pageInfo = new PageInfo(bannerList,5);

        mav.addObject("pageInfo",pageInfo);
        mav.addObject("user",user);
        List<Goods> goodsList = goodsService.findAll();
        mav.addObject("goodsList",goodsList);
        return mav;
    }
    @RequestMapping("/permissionCheck")
    public @ResponseBody boolean permissionCheck(@SessionAttribute Admin user, String operation, Integer id){
        List<RolePermissions> permissionsList = rolePermissionsService.findPermissionByRoleId(user.getId());
        for (RolePermissions permissions : permissionsList){
            if (permissions.getPermissions_id() == Integer.parseInt(operation)){
                indexBannerService.deleteById(id);
                return true;
            }
        }
        return false;
    }
    @RequestMapping("/to")
    public ModelAndView to(){
        return new ModelAndView("admin/testFile");
    }

    @PostMapping(value = "/uploads")
    public Integer uploads(
                       @RequestParam(name = "i_src") String pic,
                       @RequestParam(name = "goods_id",required = false)Integer goods_id,
                       @RequestParam(name = "type",defaultValue = "0")Integer type,
                       @RequestParam(name = "sort",defaultValue = "1")String sort,
                       @RequestParam(defaultValue = "0",required = false) Integer state) throws IOException {
       String url ="http://localhost:8080/" + UploadFile.uploadBase64(pic);
       IndexBanner banner = new IndexBanner();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        String dateStr = format.format(date);
        banner.setAdd_time(dateStr);
        banner.setI_src(url);
        banner.setGoods_id(goods_id);
        banner.setSort(sort);
        banner.setState(state);
        banner.setType(type);
        Integer flag = indexBannerService.addIndexBanner(banner);
        return flag;
    }
    @PostMapping(value = "/upload")
    public Integer upload(@RequestBody IndexBanner banner) throws IOException {
        String url ="http://localhost:8080/" + UploadFile.uploadBase64(banner.getI_src());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        String dateStr = format.format(date);
        banner.setAdd_time(dateStr);
        banner.setI_src(url);
        Integer flag = indexBannerService.addIndexBanner(banner);
        return flag;
    }
}
