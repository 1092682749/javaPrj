package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Member;

import java.util.List;

public interface MemberMapper extends Mapper<Member> {
    public Member findMemberById(Integer id);
    public List<Member> findAllOrderByTimeDesc();
    public List<Member> findMemberByPhone(String phone);
}