package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Category;

import java.util.List;

public interface CategoryMapper extends Mapper<Category> {
    public List<Category> findAllCategory();
}