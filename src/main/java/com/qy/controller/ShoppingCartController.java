package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.ShoppingCart;
import com.qy.service.ShoppingCartService;
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
@RequestMapping("/shopping/cart")
public class ShoppingCartController {
    @Resource
    private ShoppingCartService shoppingCartService;

    @PostMapping("/add")
    public Result add(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.save(shoppingCart);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        shoppingCartService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody ShoppingCart shoppingCart) {
        shoppingCartService.update(shoppingCart);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ShoppingCart shoppingCart = shoppingCartService.findById(id);
        return ResultGenerator.successResult(shoppingCart);
    }

    @GetMapping("/list")
    public ModelAndView list() {
//        PageHelper.startPage(page.getPageNum(),page.getSize());
//        List<ShoppingCart> list = shoppingCartService.findAll();
//        page.setList(list);
//        return ResultGenerator.successResult(page);
        ModelAndView mav = new ModelAndView("cart");
        return mav;
    }
//    @RequestMapping("/content")
//    public ModelAndView cart(){
//
//    }
}
