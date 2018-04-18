package com.qy.service;
import com.qy.model.Category;
import com.qy.base.core.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by zaq on 2018/04/14.
 */
public interface CategoryService extends Service<Category> {
    public Map<Integer,Category> categoryMap();//将分类以id+对象的Map返回
}
