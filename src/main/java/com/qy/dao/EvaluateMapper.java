package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Evaluate;
import com.qy.model.Member;

import java.util.List;
import java.util.Map;

public interface EvaluateMapper extends Mapper<Evaluate> {
    public List<Evaluate> findEvaluateByGoodsId(Integer id);
    public List<Map<Evaluate,Member>> findEvaluateByGoodsIdSql(Integer id);
}