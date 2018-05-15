package com.qy.service;
import com.qy.model.Member;
import com.qy.base.core.Service;

import java.util.List;


/**
 * Created by zaq on 2018/04/14.
 */
public interface MemberService extends Service<Member> {
    public Member findMemberById(Integer id);
    public List<Member> findAllOrderByTimeDesc();
    public List<Member> findMemberByPhone(String phone);
}
