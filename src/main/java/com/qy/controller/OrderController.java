package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.*;
import com.qy.service.*;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/order")
public class OrderController {
    @Resource
    private OrderService orderService;
    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private MemberService memberService;
    @Resource
    private AddressService addressService;
    @Resource
    private TransportCostService transportCostService;

    @PostMapping("/add")
    public Result add(@RequestBody Order order) {
        orderService.save(order);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        orderService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Order order) {
        orderService.update(order);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Order order = orderService.findById(id);
        return ResultGenerator.successResult(order);
    }

    @GetMapping("/list")
    public Result list(PageBean<Order> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Order> list = orderService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/manage")
    public ModelAndView manage(@SessionAttribute Admin admin){
        ModelAndView mav = new ModelAndView("admin/bannerManage");
        return mav;
    }
    @RequestMapping("buy")
    public ModelAndView buy(@RequestParam("strArr") String[] strArr){
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i<strArr.length; i++){
            System.out.println(strArr[i]);
            integers.add(Integer.parseInt(strArr[i]));
        }
        ModelAndView mav = new ModelAndView();
        Double sumPrice = 0.0;
        Double sumReduce = 0.0;
        Member member = memberService.findMemberById(shoppingCartService.findById(integers.get(0)).getS_member_id());
        Address address = addressService.findDefaultAddress(member.getId());
        TransportCost transportCost = transportCostService.findCost(address);
        //如果没有该地址的运费信息则运费为30
        if (transportCost == null){
            transportCost = new TransportCost();
            transportCost.setPrice(new BigDecimal(30));
        }
        Map<ShoppingCart,Goods> shoppingCartGoodsMap = shoppingCartService.findAllShoppingCartByIds(integers);
        for (Map.Entry<ShoppingCart,Goods> entry: shoppingCartGoodsMap.entrySet()){
            Double num = entry.getKey().getGoods_num().doubleValue();
            Double price = entry.getValue().getGoods_price().doubleValue() - entry.getValue().getGoods_reduce().doubleValue();
            sumPrice += num*price;
            sumReduce += entry.getValue().getGoods_reduce().doubleValue();
        }
        sumPrice += transportCost.getPrice().doubleValue();
        if (address == null)
        {
            ModelAndView redirect =new ModelAndView("redirect:../address/list");
            return redirect;
        }
        mav.addObject("shoppingCartGoodsMap",shoppingCartGoodsMap);

        mav.addObject("cost",transportCost.getPrice());

        mav.addObject("member",member);

        mav.addObject("address",address);

        mav.addObject("sumPrice",sumPrice);

        mav.addObject("sumReduce",sumReduce);

        mav.setViewName("submitCartOrder");
        return mav;
    }

//    @RequestMapping("/submitCartOrder")
//    public ModelAndView submitCartOrder( Map<ShoppingCart,Goods> shoppingCartGoodsMap,Member member,Address address,
//                                         TransportCost cost,Double sumPrice,Double sumReduce){
//        ModelAndView mav = new ModelAndView("submitCartOrder");
//        mav.addObject("shoppingCartGoodsMap",shoppingCartGoodsMap);
//
//        mav.addObject("cost",cost);
//
//        mav.addObject("member",member);
//
//        mav.addObject("address",address);
//
//        mav.addObject("sumPrice",sumPrice);
//
//        mav.addObject("sumReduce",sumReduce);
//        return mav;
//    }
}
