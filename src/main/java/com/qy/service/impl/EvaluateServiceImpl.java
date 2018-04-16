package com.qy.service.impl;

import com.qy.dao.EvaluateMapper;
import com.qy.model.Evaluate;
import com.qy.service.EvaluateService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class EvaluateServiceImpl extends AbstractService<Evaluate> implements EvaluateService {
    @Resource
    private EvaluateMapper evaluateMapper;

}
