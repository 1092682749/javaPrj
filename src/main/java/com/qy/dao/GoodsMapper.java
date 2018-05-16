package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper extends Mapper<Goods> {
    public Goods findGoodsById(Integer id);
    public List<Goods> findGoodsByLikeQuery(@Param("id") String id,@Param("isPut") String isPut, @Param("goodsName") String goodsName);
}