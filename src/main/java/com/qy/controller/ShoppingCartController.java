package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.*;
import com.qy.service.*;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

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
    public ModelAndView list(@SessionAttribute Member member) {
        ModelAndView mav = new ModelAndView("cart");
        Map<ShoppingCart,Goods> shoppingCartGoodsMap = shoppingCartService.findAllShoppingCartByMemberId(member.getId());
        mav.addObject("shoppingCartGoodsMap",shoppingCartGoodsMap);
        BigDecimal total = new BigDecimal(0);
        int allNum = 0;
        for (Map.Entry<ShoppingCart,Goods> entry : shoppingCartGoodsMap.entrySet())
        {
            BigDecimal goodsNum = new BigDecimal(entry.getKey().getGoods_num());
            BigDecimal oneTotal = (entry.getValue().getGoods_price().subtract(entry.getValue().getGoods_reduce())).multiply(goodsNum);
            total = total.add(oneTotal);
            allNum = allNum + entry.getKey().getGoods_num();

        }
        mav.addObject("total",total);
        mav.addObject("allNum",allNum);
        return mav;
    }

    @PostMapping("/addCart")
    @ResponseBody
    public Map<String,Integer> number(@RequestBody ShoppingCart shoppingCart){
        Map<String,Integer> map = new HashMap<>();
        Date date = new Date();
        shoppingCart.setS_add_time(new SimpleDateFormat("yyyy-MM-dd").format(date));
        shoppingCartService.save(shoppingCart);
        System.out.println("################"+shoppingCart.toString());
        Integer cartNum = shoppingCartService.findAllShoppingCartByMemberId(shoppingCart.getS_member_id()).size();
        map.put("cartNum",cartNum);
        return map;
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
        if (address == null)
        {
            ModelAndView redirect =new ModelAndView("redirect:../../address/list");
            return redirect;
        }
        mav.addObject("address",address);
        TransportCost transportCost = transportCostService.findCost(address);
        mav.addObject("cost",transportCost);
        return mav;
    }

}
