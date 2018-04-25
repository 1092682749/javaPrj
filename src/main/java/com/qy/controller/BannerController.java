package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.model.Banner;
import com.qy.service.BannerService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Resource
    private BannerService bannerService;

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
    public ModelAndView manage(@SessionAttribute Admin admin){
        ModelAndView mav = new ModelAndView("admin/bannerManage");
        List<Banner> bannerList = bannerService.findAll();
        mav.addObject("bannerList",bannerList);
        return mav;
    }
}
