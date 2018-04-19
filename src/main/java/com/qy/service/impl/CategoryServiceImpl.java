package com.qy.service.impl;

import com.qy.dao.CategoryMapper;
import com.qy.model.Category;
import com.qy.service.CategoryService;
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
public class CategoryServiceImpl extends AbstractService<Category> implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    /**
     * 以商品分类的id为key，分类对象为value
     * @return
     */
    @Override
    public Map<Integer, Category> categoryMap() {
        List<Category> categoryList = categoryMapper.findAllCategory();
        Map<Integer,Category> categoryMap = new HashMap<>();
        for (Category category : categoryList)
        {
            Integer id = category.getId();
            categoryMap.put(id,category);
        }
        return categoryMap;
    }
}
