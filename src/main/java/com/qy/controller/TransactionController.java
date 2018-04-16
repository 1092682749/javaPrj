package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Transaction;
import com.qy.service.TransactionService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Resource
    private TransactionService transactionService;

    @PostMapping("/add")
    public Result add(@RequestBody Transaction transaction) {
        transactionService.save(transaction);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        transactionService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Transaction transaction) {
        transactionService.update(transaction);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Transaction transaction = transactionService.findById(id);
        return ResultGenerator.successResult(transaction);
    }

    @GetMapping("/list")
    public Result list(PageBean<Transaction> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Transaction> list = transactionService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
