package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.IndexBanner;
import com.qy.service.IndexBannerService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by dyz on 2018/04/23.
*/
@RestController
@RequestMapping("/index/banner")
public class IndexBannerController {
    @Resource
    private IndexBannerService indexBannerService;

    @PostMapping("/add")
    public Result add(@RequestBody IndexBanner indexBanner) {
        indexBannerService.save(indexBanner);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        indexBannerService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody IndexBanner indexBanner) {
        indexBannerService.update(indexBanner);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        IndexBanner indexBanner = indexBannerService.findById(id);
        return ResultGenerator.successResult(indexBanner);
    }

    @GetMapping("/list")
    public Result list(PageBean<IndexBanner> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<IndexBanner> list = indexBannerService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
