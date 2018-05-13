package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.IndexBanner;

public interface IndexBannerMapper extends Mapper<IndexBanner> {
    public int addIndexBanner(IndexBanner banner);
}