package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Member;
import com.qy.model.ShoppingCart;

import java.util.List;

public interface ShoppingCartMapper extends Mapper<ShoppingCart> {
    public List<ShoppingCart> findAllShoppingCartByMemberId(Integer id);
}