package com.qy.service.impl;

import com.qy.dao.MemberMapper;
import com.qy.model.Member;
import com.qy.service.MemberService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class MemberServiceImpl extends AbstractService<Member> implements MemberService {
    @Resource
    private MemberMapper memberMapper;

    @Override
    public Member findMemberById(Integer id) {
        return memberMapper.findMemberById(id);
    }

    @Override
    public List<Member> findAllOrderByTimeDesc() {
        return memberMapper.findAllOrderByTimeDesc();
    }

    @Override
    public List<Member> findMemberByPhone(String phone) {
        return memberMapper.findMemberByPhone(phone);
    }
}
