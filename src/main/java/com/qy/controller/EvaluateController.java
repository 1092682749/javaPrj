package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Evaluate;
import com.qy.service.EvaluateService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/evaluate")
public class EvaluateController {
    @Resource
    private EvaluateService evaluateService;

    @PostMapping("/add")
    public Result add(@RequestBody Evaluate evaluate) {
        evaluateService.save(evaluate);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        evaluateService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Evaluate evaluate) {
        evaluateService.update(evaluate);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Evaluate evaluate = evaluateService.findById(id);
        return ResultGenerator.successResult(evaluate);
    }

    @GetMapping("/list")
    public Result list(PageBean<Evaluate> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Evaluate> list = evaluateService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
