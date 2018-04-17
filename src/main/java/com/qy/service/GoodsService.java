package com.qy.service;
import com.qy.model.Goods;
import com.qy.base.core.Service;


/**
 * Created by zaq on 2018/04/14.
 */
public interface GoodsService extends Service<Goods> {
        public Goods findGoodsById(Integer id);
}
