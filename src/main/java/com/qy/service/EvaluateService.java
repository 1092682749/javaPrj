package com.qy.service;
import com.qy.model.Evaluate;
import com.qy.base.core.Service;
import com.qy.model.Member;

import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
public interface EvaluateService extends Service<Evaluate> {
        public List<Evaluate> findEvaluateByGoodsId(Integer id);
        public Map<Evaluate,Member> evaluateMemberMap(Integer id);
        public List<Map<Evaluate,Member>> findEvaluateByGoodsIdSql(Integer id);
}
