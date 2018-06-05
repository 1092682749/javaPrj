package com.qy.controller;
import com.github.pagehelper.PageInfo;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Admin;
import com.qy.model.Banner;
import com.qy.service.AdminService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import com.qy.service.BannerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.jws.WebParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/admin")
@SessionAttributes(names = {"admin","user"})
public class AdminController {
    @Resource
    private AdminService adminService;
    @Resource
    private BannerService bannerService;

    @PostMapping("/add")
    public Result add(@RequestBody Admin admin) {
        adminService.save(admin);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        adminService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Admin admin) {
        adminService.update(admin);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Admin admin = adminService.findById(id);
        return ResultGenerator.successResult(admin);
    }

    @GetMapping("/list")
    public Result list(PageBean<Admin> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Admin> list = adminService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
    @RequestMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("admin/login");
        return mav;
    }

    @RequestMapping("/verify")
    @ResponseBody
    public Map<String,Object> verify(@RequestBody Admin admin){
        Map<String,Object> returnMap = new HashMap<>();
        Map<String,Object> verifyMap= adminService.verify(admin);
        returnMap = verifyMap;
        return returnMap;
    }
    @RequestMapping("index")
    public ModelAndView index(@Param("id")Integer id,@RequestParam(value = "password",required = true)String password,Model model){
        Admin user = adminService.findById(id);
//        model.addAttribute("user",user);
//        System.out.println(user.getId());
        ModelAndView mav = new ModelAndView();
        model.addAttribute("user",user);
//        mav.addObject("user",user);
        mav.setViewName("redirect:/banner/manage");
        return mav;
    }
}
