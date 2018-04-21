package com.qy.service.impl;

import com.qy.dao.ShoppingCartMapper;
import com.qy.model.Goods;
import com.qy.model.ShoppingCart;
import com.qy.service.GoodsService;
import com.qy.service.ShoppingCartService;
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
public class ShoppingCartServiceImpl extends AbstractService<ShoppingCart> implements ShoppingCartService {
    @Resource
    private ShoppingCartMapper shoppingCartMapper;
    @Resource
    private GoodsService goodsService;

    @Override
    public Map<ShoppingCart,Goods> findAllShoppingCartByMemberId(Integer id) {
        Map<ShoppingCart,Goods> shoppingCartGoodsMap = new HashMap<>();
        List<ShoppingCart> shoppingCartList = shoppingCartMapper.findAllShoppingCartByMemberId(id);
        for (ShoppingCart shoppingCart : shoppingCartList)
        {
            Goods goods = goodsService.findGoodsById(shoppingCart.getGoods_id());
            shoppingCartGoodsMap.put(shoppingCart,goods);
        }
        return shoppingCartGoodsMap;
    }
}
