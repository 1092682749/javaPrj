package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.OrderGoods;
import com.qy.service.OrderGoodsService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/order/goods")
public class OrderGoodsController {
    @Resource
    private OrderGoodsService orderGoodsService;

    @PostMapping("/add")
    public Result add(@RequestBody OrderGoods orderGoods) {
        orderGoodsService.save(orderGoods);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        orderGoodsService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody OrderGoods orderGoods) {
        orderGoodsService.update(orderGoods);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        OrderGoods orderGoods = orderGoodsService.findById(id);
        return ResultGenerator.successResult(orderGoods);
    }

    @GetMapping("/list")
    public Result list(PageBean<OrderGoods> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<OrderGoods> list = orderGoodsService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
