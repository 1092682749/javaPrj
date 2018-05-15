package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Category;
import com.qy.service.CategoryService;
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
@RequestMapping("/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @PostMapping("/add")
    public Result add(@RequestBody Category category) {
        categoryService.save(category);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        categoryService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Category category) {
        categoryService.update(category);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Category category = categoryService.findById(id);
        return ResultGenerator.successResult(category);
    }

    @GetMapping("/list")
    public Result list(PageBean<Category> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Category> list = categoryService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/manage")
    public ModelAndView manage(){
        ModelAndView mav = new ModelAndView("admin/categoryManage");
        List<Category> categoryList = categoryService.findAll();
        mav.addObject("categoryList",categoryList);
        return mav;
    }
}
