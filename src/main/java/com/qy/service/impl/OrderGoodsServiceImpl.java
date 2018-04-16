package com.qy.service.impl;

import com.qy.dao.OrderGoodsMapper;
import com.qy.model.OrderGoods;
import com.qy.service.OrderGoodsService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class OrderGoodsServiceImpl extends AbstractService<OrderGoods> implements OrderGoodsService {
    @Resource
    private OrderGoodsMapper orderGoodsMapper;

}
