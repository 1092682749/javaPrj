package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Goods;

public interface GoodsMapper extends Mapper<Goods> {
    public Goods findGoodsById(Integer id);
}