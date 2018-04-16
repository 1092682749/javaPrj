package com.qy.service.impl;

import com.qy.dao.ShoppingCartMapper;
import com.qy.model.ShoppingCart;
import com.qy.service.ShoppingCartService;
import com.qy.base.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by zaq on 2018/04/14.
 */
@Service
@Transactional
public class ShoppingCartServiceImpl extends AbstractService<ShoppingCart> implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;

}
