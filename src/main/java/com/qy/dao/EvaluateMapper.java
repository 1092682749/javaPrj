package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Evaluate;

import java.util.List;

public interface EvaluateMapper extends Mapper<Evaluate> {
    public List<Evaluate> findEvaluateByGoodsId(Integer id);
}