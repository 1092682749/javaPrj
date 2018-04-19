package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.*;
import com.qy.service.*;
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
    @Resource
    private GoodsService goodsService;
    @Resource
    private MemberService memberService;
    @Resource
    private AddressService addressService;
    @Resource
    private TransportCostService transportCostService;

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
    @PostMapping("/addCart")
    public void number(@RequestBody ShoppingCart shoppingCart){
//        shoppingCart.setS_member_id(member.getId());
        System.out.println("################"+shoppingCart.toString());
    }
    @PostMapping("/buyNew")
    public ModelAndView submitOrder(ShoppingCart shoppingCart){
        ModelAndView mav = new ModelAndView("submitOrder");
        mav.addObject("shoppingCart",shoppingCart);
        Goods goods = goodsService.findGoodsById(shoppingCart.getGoods_id());
        mav.addObject("goods",goods);
        Member member = memberService.findMemberById(shoppingCart.getS_member_id());
        mav.addObject("member",member);
        Address address = addressService.findDefaultAddress(member.getId());
        mav.addObject("address",address);
        TransportCost transportCost = transportCostService.findCost(address);
        mav.addObject("cost",transportCost);
        return mav;
    }
}
