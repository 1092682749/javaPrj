package com.qy.controller;
import com.qy.base.core.Result;
import com.qy.base.core.ResultGenerator;
import com.qy.model.Member;
import com.qy.service.MemberService;
import com.qy.base.core.PageBean;
import com.github.pagehelper.PageHelper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by zaq on 2018/04/14.
*/
@RestController
@RequestMapping("/member")
public class MemberController {
    @Resource
    private MemberService memberService;

    @PostMapping("/add")
    public Result add(@RequestBody Member member) {
        memberService.save(member);
        return ResultGenerator.successResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Integer id) {
        memberService.deleteById(id);
        return ResultGenerator.successResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody Member member) {
        memberService.update(member);
        return ResultGenerator.successResult();
    }

    @GetMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        Member member = memberService.findById(id);
        return ResultGenerator.successResult(member);
    }

    @GetMapping("/list")
    public Result list(PageBean<Member> page) {
        PageHelper.startPage(page.getPageNum(),page.getSize());
        List<Member> list = memberService.findAll();
        page.setList(list);
        return ResultGenerator.successResult(page);
    }
}
