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

    /**
     * 按商品id查询出该商品的所有评价
     * @param id
     * @return
     */
    @Override
    public List<Evaluate> findEvaluateByGoodsId(Integer id) {
        return evaluateMapper.findEvaluateByGoodsId(id);
    }

    /**
     * 将评价和用户以键值对的形式保存并返回
     * @param id
     * @return
     */
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

    @Override
    public List<Map<Evaluate,Member>> findEvaluateByGoodsIdSql(Integer id) {
        return evaluateMapper.findEvaluateByGoodsIdSql(id);
    }
}
