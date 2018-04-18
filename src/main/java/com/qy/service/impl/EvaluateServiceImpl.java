package com.qy.service.impl;

import com.qy.dao.EvaluateMapper;
import com.qy.dao.MemberMapper;
import com.qy.model.Evaluate;
import com.qy.model.Member;
import com.qy.service.EvaluateService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class EvaluateServiceImpl extends AbstractService<Evaluate> implements EvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;
    @Resource
    private MemberMapper memberMapper;

    @Override
    public List<Evaluate> findEvaluateByGoodsId(Integer id) {
        return evaluateMapper.findEvaluateByGoodsId(id);
    }

    @Override
    public Map<Evaluate, Member> evaluateMemberMap(Integer id) {
        Map<Evaluate,Member> evaluateMemberMap = new HashMap<>();
        List<Evaluate> evaluateList = findEvaluateByGoodsId(id);
        for (Evaluate evaluate:evaluateList){
            Member member = memberMapper.findMemberById(evaluate.getMember_id());
            evaluateMemberMap.put(evaluate,member);
        }
        return evaluateMemberMap;
    }
}
