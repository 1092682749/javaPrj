package com.qy.service.impl;

import com.qy.dao.TransportCostMapper;
import com.qy.model.TransportCost;
import com.qy.service.TransportCostService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class TransportCostServiceImpl extends AbstractService<TransportCost> implements TransportCostService {
    @Resource
    private TransportCostMapper transportCostMapper;

}
