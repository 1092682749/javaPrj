package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.*;
import com.qy.service.*;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private GoodsService goodsService;
    @Resource
    private BannerService bannerService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private EvaluateService evaluateService;
    @Resource
    private MemberService memberService;

    @PostMapping("/add")
    public Result add(@RequestBody Goods goods) {
        goodsService.save(goods);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        goodsService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Goods goods) {
        goodsService.update(goods);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Goods goods = goodsService.findById(id);
        return ResultGenerator.successResult(goods);
    }

    @GetMapping("/list")
    public Result list(PageBean<Goods> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Goods> list = goodsService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/details")
    public ModelAndView details(Integer id)
    {
        ModelAndView mav = new ModelAndView("shopDetails");
        Map<Evaluate,Member> evaluateMemberMap = evaluateService.evaluateMemberMap(id);
        List<Banner> banners = bannerService.findBannersById(id);
        Goods goods = goodsService.findGoodsById(id);
        mav.addObject("evaluateMemberMap",evaluateMemberMap);
        mav.addObject("banners",banners);
        mav.addObject("goods",goods);
        return mav;
    }
    @RequestMapping("/shopAll")
    public ModelAndView shopAll()
    {
        ModelAndView mav = new ModelAndView("shopAll");
        Map<Integer,Category> categoryMap = categoryService.categoryMap();
        List<Goods> goodsList = goodsService.findAll();
        mav.addObject("categoryMap",categoryMap);
        mav.addObject("goodsList",goodsList);
        for (Goods g : goodsList) {
            System.out.println(g.getCategory_id());
            System.out.println(categoryMap.get(g.getCategory_id()).getC_name());
        }

        return mav;
    }
//    @RequestMapping
}
