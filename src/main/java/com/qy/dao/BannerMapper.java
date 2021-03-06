package com.qy.dao;

import com.qy.base.core.Mapper;
import com.qy.model.Banner;
import com.qy.model.IndexBanner;

import java.util.List;

public interface BannerMapper extends Mapper<Banner> {
    public List<Banner> findBannersById(Integer id);
}