package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.model.SystemMessage;
import com.qy.service.SystemMessageService;
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
@RequestMapping("/system/message")
public class SystemMessageController {
    @Resource
    private SystemMessageService systemMessageService;

    @PostMapping("/add")
    public Result add(@RequestBody SystemMessage systemMessage) {
        systemMessageService.save(systemMessage);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        systemMessageService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody SystemMessage systemMessage) {
        systemMessageService.update(systemMessage);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        SystemMessage systemMessage = systemMessageService.findById(id);
        return ResultGenerator.successResult(systemMessage);
    }

    @GetMapping("/list")
    public Result list(PageBean<SystemMessage> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<SystemMessage> list = systemMessageService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/all")
    public ModelAndView all(){
        ModelAndView mav = new ModelAndView("admin/bannerManage");
        return mav;
    }
    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin admin){
        ModelAndView mav = new ModelAndView("admin/bannerManage");
        return mav;
    }
}
