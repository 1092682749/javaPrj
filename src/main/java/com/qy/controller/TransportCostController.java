package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.model.TransportCost;
import com.qy.service.TransportCostService;
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
@RequestMapping("/transport/cost")
public class TransportCostController {
    @Resource
    private TransportCostService transportCostService;

    @PostMapping("/add")
    public Result add(@RequestBody TransportCost transportCost) {
        transportCostService.save(transportCost);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        transportCostService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody TransportCost transportCost) {
        transportCostService.update(transportCost);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        TransportCost transportCost = transportCostService.findById(id);
        return ResultGenerator.successResult(transportCost);
    }

    @GetMapping("/list")
    public Result list(PageBean<TransportCost> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<TransportCost> list = transportCostService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin admin){
        ModelAndView mav = new ModelAndView("admin/bannerManage");
        return mav;
    }
}
