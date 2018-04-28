package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Address;
import com.qy.model.Member;
import com.qy.service.AddressService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @PostMapping("/add")
    public ModelAndView add(Address address,@SessionAttribute Member member) {
        boolean hasDefault = false;
        address.setAdd_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        address.setMember_id(member.getId());
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
        for (Address a : addressList){
            if (a.getIs_default() == 1){
                hasDefault = true;
            }
        }
        if (hasDefault == false){
            address.setIs_default(1);
        }else {
            address.setIs_default(0);
        }
        addressService.save(address);
        ModelAndView mav = new ModelAndView("address");
        mav.addObject("addressList",addressList);
        System.out.println("########add#########");
        return mav;
    }

    @GetMapping("/delete")
    public ModelAndView delete(Integer id,@SessionAttribute Member member) {
        addressService.deleteById(id);
        ModelAndView mav = new ModelAndView("address");
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
        mav.addObject("addressList",addressList);
        System.out.println("########add#########");
        return mav;
    }

    @PostMapping("/update")
    public ModelAndView update(Address address,@SessionAttribute Member member) {
        System.out.println("########update#########");
//        address.setAdd_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        address.setMember_id(member.getId());
        addressService.updateAddress(address);
        ModelAndView mav = new ModelAndView("address");
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
        mav.addObject("addressList",addressList);
        return mav;
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Address address = addressService.findById(id);
        return ResultGenerator.successResult(address);
    }

    @GetMapping("/list")
    public ModelAndView addressList(@SessionAttribute Member member){
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
        ModelAndView mav = new ModelAndView("address");
        mav.addObject("addressList",addressList);
        return mav;
    }
    @GetMapping("/setAddress")
    public void setAddress(String id,@SessionAttribute Member member){
        Map<String,String> stringMap = new HashMap<>();
        Integer integerId = Integer.parseInt(id);
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
        for (Address address : addressList){
            if (address.getIs_default() == 1)
            {
                address.setIs_default(0);
            }
            if (address.getId() == integerId)
            {
                address.setIs_default(1);
            }
        }
//        return stringMap;
    }
}
