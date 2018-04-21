package com.qy.service;
import com.qy.model.Goods;
import com.qy.model.ShoppingCart;
import com.qy.base.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
public interface ShoppingCartService extends Service<ShoppingCart> {
    public Map<ShoppingCart,Goods> findAllShoppingCartByMemberId(Integer id);
}
