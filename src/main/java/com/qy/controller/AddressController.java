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
    public Result add(@RequestBody Address address) {
        addressService.save(address);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        addressService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Address address) {
        addressService.update(address);
        return ResultGenerator.successResult();
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
