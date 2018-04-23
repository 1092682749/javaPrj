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
import java.util.List;

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
        address.setAdd_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        address.setMember_id(member.getId());
        addressService.save(address);
        ModelAndView mav = new ModelAndView("address");
        List<Address> addressList = addressService.findAddressByMemberId(member.getId());
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
}
