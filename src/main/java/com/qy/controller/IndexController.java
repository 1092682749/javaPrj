package com.qy.controller;

import com.qy.base.core.PageBean;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.base.utils.DateUtil;
import com.qy.base.utils.UploadFile;
import com.qy.model.Banner;
import com.qy.model.Goods;
import com.qy.model.Member;
import com.qy.service.BannerService;
import com.qy.service.GoodsService;
import com.qy.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/03/24.
*/
@RestController
@RequestMapping("/")
public class IndexController {
    @Autowired
    private BannerService bannerService;
    @Resource
    private GoodsService goodsService;

    @RequestMapping("/home")
    public ModelAndView home() {
        UploadFile.uploadBase64("data:image/png;base64,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");
        ModelAndView modelAndView = new ModelAndView("home");
        List<Banner> bannerList = bannerService.findAll();
        modelAndView.addObject("bannerList",bannerList);
        return modelAndView;
    }
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        return mav;
    }
}
